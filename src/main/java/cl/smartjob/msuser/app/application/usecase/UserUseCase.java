package cl.smartjob.msuser.app.application.usecase;

import cl.smartjob.msuser.app.application.ports.input.UserRestServicePort;
import cl.smartjob.msuser.app.application.ports.output.RegularExpressionPersistencePort;
import cl.smartjob.msuser.app.application.ports.output.UserPersistencePort;
import cl.smartjob.msuser.app.domain.exception.UserException;
import cl.smartjob.msuser.app.domain.model.User;
import cl.smartjob.msuser.app.infraestructure.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserUseCase implements UserRestServicePort {

    private final UserPersistencePort userPort;
    private final RegularExpressionPersistencePort regularExpressionPort;

    @Override
    public User save(String token, User user) {
        user.setToken(token.replace(Constants.BEARER, Constants.BLANK));
        user.setActivityStatus();
        emailValidation(user.getEmail());
        passwordValidation(user.getPassword());

        return userPort.save(user);
    }

    @Override
    public List<User> findAll() {
        return userPort.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userPort.findById(id)
                .orElseThrow(UserException::new);
    }

    @Override
    public User update(UUID id, User user) {
        passwordValidation(user.getPassword());
        return userPort.findById(id).map(savedUser -> {
            savedUser.setId(user.getId());
            savedUser.setName(user.getName());
            savedUser.setEmail(user.getEmail());
            savedUser.setPassword(user.getPassword());
            savedUser.setToken(user.getToken());
            savedUser.setCreated(user.getCreated());
            savedUser.setModified(user.getModified());
            savedUser.setLastLogin(user.getLastLogin());
            savedUser.setPhones(user.getPhones());
            savedUser.setIsActive(user.getIsActive());
            return userPort.save(savedUser);
        }).orElseThrow(UserException::new);
    }

    @Override
    public void deleteById(UUID id) {
         if(userPort.findById(id).isEmpty()){
             throw new UserException();
         }
         userPort.deleteById(id);
    }

    private void emailValidation(String email) {
        if (userPort.findOneByEmailAndIsActive(email, true).isPresent()) {
            try {
                throw new Exception(
                        String.format(Constants.EMAIL_ADDRESS_ALREADY_EXISTS, email));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private  void passwordValidation(String password) {

        var re = regularExpressionPort.findOneByCode(Constants.PASSWORD_REGULAR_EXPRESSION_CODE);
        if(re.isEmpty()){
            try {
                throw new Exception(Constants.REGULAR_EXPRESSION_NOT_FOUND_MESSAGE_ERROR);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        var exp = re.get().getExpression();
        if(!Pattern.compile(exp).matcher(password).find()){
            try {
                throw new Exception(Constants.INVALID_PASSWORD_FORMAT_ERROR);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}

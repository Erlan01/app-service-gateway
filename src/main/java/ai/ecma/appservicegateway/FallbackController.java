package ai.ecma.appservicegateway;

import ai.ecma.lib.payload.ApiResult;
import ai.ecma.lib.payload.ErrorData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 17.02.2022
 */
@RestController
public class FallbackController {
    String ERROR_MESSAGE = "There was a problem connecting to the Service";
    HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.PATCH},
            path = "/fallback")
    public ResponseEntity<?> fallbackController() {
        return ResponseEntity
                .status(HTTP_STATUS)
                .body(new ApiResult<>(false, List.of(new ErrorData(ERROR_MESSAGE, HTTP_STATUS.value()))));
    }

}

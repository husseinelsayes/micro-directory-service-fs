package directoryDeliveryMechanism.view;

import java.util.List;

public class ApiResponse {
    private boolean error;
    private List<String> payload;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    public List<String> getPayload() {
        return payload;
    }

    public void setPayload(List<String> payload) {
        this.payload = payload;
    }

    public ApiResponse(boolean error, List<String> payload) {
        this.error = error;
        this.payload = payload;
    }

    
    
}

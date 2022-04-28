package model.objects.errors;

import com.google.gson.annotations.SerializedName;

public class Errors {
    @SerializedName("error")
    ErrorDetails errorDetails;

    public String getMessage() {
        return this.errorDetails.toString();
    }
}

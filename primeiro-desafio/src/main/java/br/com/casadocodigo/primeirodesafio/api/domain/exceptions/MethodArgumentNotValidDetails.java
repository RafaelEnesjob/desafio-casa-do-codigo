package br.com.casadocodigo.primeirodesafio.api.domain.exceptions;

public class MethodArgumentNotValidDetails {

    private String messageError;
    private int Status;
    private String detailError;

    private MethodArgumentNotValidDetails() {
    }

    public String getMessageError() {
        return messageError;
    }

    public int getStatus() {
        return Status;
    }

    public String getDetailError() {
        return detailError;
    }

    public static final class Builder {
        private String messageError;
        private int Status;
        private String detailError;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder messageError(String messageError) {
            this.messageError = messageError;
            return this;
        }

        public Builder Status(int Status) {
            this.Status = Status;
            return this;
        }

        public Builder detailError(String detailError) {
            this.detailError = detailError;
            return this;
        }

        public MethodArgumentNotValidDetails build() {
            MethodArgumentNotValidDetails methodArgumentNotValidDetails = new MethodArgumentNotValidDetails();
            methodArgumentNotValidDetails.Status = this.Status;
            methodArgumentNotValidDetails.messageError = this.messageError;
            methodArgumentNotValidDetails.detailError = this.detailError;
            return methodArgumentNotValidDetails;
        }
    }
}

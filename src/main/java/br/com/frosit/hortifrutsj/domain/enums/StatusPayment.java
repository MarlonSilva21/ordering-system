package br.com.frosit.hortifrutsj.domain.enums;

public enum StatusPayment {

    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private int code;

    private StatusPayment(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ClientType toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (ClientType clientType : ClientType.values()) {
            if (code.equals(clientType.getCode())) {
                return clientType;
            }
        }

        throw new IllegalArgumentException("Id Inválido: " + code);

    }
}

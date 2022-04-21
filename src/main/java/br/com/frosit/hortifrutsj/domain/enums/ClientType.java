package br.com.frosit.hortifrutsj.domain.enums;

public enum ClientType {

    PESSOA_FISICA(1),
    PESSOA_JURIDICA(2);

    private final int code;

    private ClientType(int code) {
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

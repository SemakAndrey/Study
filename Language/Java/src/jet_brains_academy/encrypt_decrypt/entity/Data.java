package jet_brains_academy.encrypt_decrypt.entity;

import jet_brains_academy.encrypt_decrypt.utils.IOHandlerUtil;

public class Data {

    private String mode = "enc";
    private String in = "";
    private String out = "";
    private String data = "";
    private String dataModify = "";
    private String alg = "shift";
    private int key = 0;

    public Data(String[] args) {

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    this.mode = args[++i];
                    break;
                case "-alg":
                    this.alg = args[++i];
                    break;
                case "-key":
                    this.key = Integer.parseInt(args[++i]);
                    break;
                case "-data":
                    this.data = args[++i];
                    break;
                case "-in":
                    this.in = args[++i];
                    break;
                case "-out":
                    this.out = args[++i];
                    break;
            }
        }

        if (this.data.isBlank()) {
            this.data = IOHandlerUtil.readData(this.in);
        }
    }

    public String getMode() {
        return mode;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getData() {
        return data;
    }

    public String getAlg() {
        return alg;
    }

    public int getKey() {
        return key;
    }

    public String getDataModify() {
        return dataModify;
    }

    public void setDataModify(String dataModify) {
        this.dataModify = dataModify;
    }
}

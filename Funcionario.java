public class Funcionario {

    private static Integer contadorID = 1;

    private Integer idFuncionario;
    private String nomeFuncionario;

    public Funcionario(String nomeFuncionario) {
        this.idFuncionario = contadorID;
        contadorID++;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Funcionario(){}

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public static void infoFuncionario(Funcionario funcionario){
        System.out.print("Id: " + funcionario.getIdFuncionario());
        System.out.print("Nome: " + funcionario.getNomeFuncionario());
    }


}

public class Funcionario {

    private static Integer contadorID = 1;

    private final Integer idFuncionario;
    private String nomeFuncionario;

    public Funcionario(String nomeFuncionario) {
        this.idFuncionario = contadorID;
        contadorID++;
        this.nomeFuncionario = nomeFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void infoFuncionario(){
        System.out.println("Id: " + idFuncionario + " | Nome: " + nomeFuncionario);
    }

}

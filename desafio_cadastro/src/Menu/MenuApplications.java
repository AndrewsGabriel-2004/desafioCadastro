package Menu;

import Cadastramento.AlterarCadastro;
import Cadastramento.CadastroDosPets;
import Cadastramento.DefinirCriterios;

import java.util.Scanner;

public class MenuApplications {
    CadastroDosPets cp = new CadastroDosPets();
    DefinirCriterios bp = new DefinirCriterios();
    AlterarCadastro ac = new AlterarCadastro();
    Scanner sc = new Scanner(System.in);
    char indicator;
    int indicatorConfirmation;

    public void showMenu() {
        System.out.println("Menu: ");
        System.out.println("1.Cadastrar um novo pet");
        System.out.println("2.Listar pets por algum critério (idade, nome, raça");
        System.out.println("3.Alterar os dados do pet cadastrado");
        System.out.println("4.Deletar um pet cadastrado");
        System.out.println("5.Listar todos os pets cadastrados");
        System.out.println("6.Sair");
        System.out.print("Escolha uma das opções: ");
        indicator = sc.next().charAt(0);
        int type = Character.getType(indicator);
        if (Character.isLetter(indicator) || type == Character.START_PUNCTUATION || type == Character.END_PUNCTUATION || type == Character.OTHER_PUNCTUATION) {
            showMenu();
        } else {
            indicatorConfirmation = Character.getNumericValue(indicator);
            if (indicatorConfirmation > 6 || indicatorConfirmation <= 0) {
                showMenu();
            }
        }
        switch (indicatorConfirmation) {
            case 1:
                cp.cadastrarNovosPets();
                showMenu();

            case 2:
                bp.definirCriterios();
                showMenu();
            case 3:
                ac.alterarCadastro();
                showMenu();
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
        }
    }
}


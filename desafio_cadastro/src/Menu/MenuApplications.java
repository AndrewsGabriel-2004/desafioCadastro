package Menu;

import Cadastramento.CadastroDosPets;
import Cadastramento.DefinirCriterios;

import java.util.Scanner;

public class MenuApplications {
    CadastroDosPets cp = new CadastroDosPets();
    DefinirCriterios bp = new DefinirCriterios();
    Scanner sc = new Scanner(System.in);
    String indicator;
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
        indicator = sc.nextLine();
        for(int i = 0; i < indicator.length(); i++){
            char confirmation = indicator.charAt(i);
            if(Character.isLetter(confirmation)){
                showMenu();
            }else {
                indicatorConfirmation = Integer.parseInt(indicator);
                if (indicatorConfirmation > 6 || indicatorConfirmation <=0){
                    showMenu();
                }
            }
        }

        switch (indicatorConfirmation){
            case 1:
                cp.cadastrarNovosPets();
                showMenu();
            case 2:
                bp.definirCriterios();
                showMenu();
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
        }

    }


}


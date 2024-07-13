package util;

import bean.Client;
import bean.OrdinaryClient;
import menu.loginmenu.ExitProgram;
import menu.loginmenu.HiddenOption;
import menu.loginmenu.LoginAccount;
import menu.loginmenu.RegisterAccount;
import menu.loginmenu.inter.LoginMenu;
import menu.mainmenu.*;
import menu.mainmenu.inter.MainMenu;

public class Show {

    public static void entryScreen() {
        System.out.println("\nMÜCƏRRƏD BANKA XOŞ GƏLMİSİNİZ! HESABINIZA DAXİL OLUN" +
                "\nVƏ YA ASAN QEYDİYYAT İLƏ MÜŞTƏRİMİZƏ ÇEVRİLİN\n");
        loginMenu();
    }

    public static void loginMenu() {
        while (true) {
            int selectedMenu = Input.number("1. Hesaba daxil ol\n2. Qeydiyyatdan keç\n3. Çıxış");
            if (selectedMenu == 1) {
                loginMenuProcess(new LoginAccount());
            } else if (selectedMenu == 2) {
                loginMenuProcess(new RegisterAccount());
            } else if (selectedMenu == 3) {
                loginMenuProcess(new ExitProgram());
            } else if (selectedMenu == 1998) {
                //Bütün müştərilərin siyahısını göstərən gizli bir seçim
                loginMenuProcess(new HiddenOption());
            } else {
                System.out.println("Menyunu düzgün daxil edin!\n");
            }
        }
    }

    public static void loginMenuProcess(LoginMenu selectedMenu) {
        selectedMenu.process();
    }

    public static void mainMenu(Client client) {
        while (true) {
            int selectedMenu = Input.number("1. Balansa bax" + "\n2. Balansı artır" +
                    "\n3. Pul nağdlaşdır" + "\n4. Köçürmə et" + "\n5. Profilə bax" + "\n6. Hesabdan çıx");
            if (selectedMenu == 1) {
                mainMenuProcess(new CheckBalance(), client);
            } else if (selectedMenu == 2) {
                mainMenuProcess(new PlusBalance(), client);
            } else if (selectedMenu == 3) {
                mainMenuProcess(new MinusBalance(), client);
            } else if (selectedMenu == 4) {
                mainMenuProcess(new MoneyTransfer(), client);
            } else if (selectedMenu == 5) {
                mainMenuProcess(new ViewProfile(), client);
            } else if (selectedMenu == 6) {
                mainMenuProcess(new LogoutAccount(), client);
                break;
            } else {
                System.out.println("Menyunu düzgün daxil edin!\n");
            }
        }
    }

    public static void mainMenuProcess(MainMenu selectedMenu, Client client) {
        selectedMenu.process(client);
    }
}

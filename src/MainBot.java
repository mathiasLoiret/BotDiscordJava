import java.util.Scanner;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class MainBot {

	private JDA jda;
	private boolean stop = false;

	public MainBot() {

		try {
			jda = new JDABuilder(AccountType.BOT).setToken("KKu5evlrXZKYbmAxMO3qdxxubUieQvUx").buildBlocking();
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Une erreur de connexion est survenue, vérifiez le token");
			return;
		}
		System.out.println("Connecte avec: " + jda.getSelfUser().getName());
		int i;
		System.out.println("Le bot est autorisé sur " + (i = jda.getGuilds().size()) + " serveur" + (i > 1 ? "s" : ""));
		while (!stop) {
			Scanner scanner = new Scanner(System.in);
			String cmd = scanner.next();
			if (cmd.equalsIgnoreCase("stop")) {
				jda.shutdown();
				stop = true;
			}
		}

	}

	public static void main(String[] args) {

//		if (args.length < 1) {
//			System.out.println("Indiquer le token du bot");
//		}
		new MainBot();
	}

}

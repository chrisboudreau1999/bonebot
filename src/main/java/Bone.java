import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import Commands.bonepics;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Bone extends ListenerAdapter {
	public static void main(String[] args) throws Exception {

		JDA jda = new JDABuilder(AccountType.BOT).setToken("put your bot's token here").buildBlocking();

		CommandClientBuilder builder = new CommandClientBuilder();

		builder.setOwnerId("insert your owner id");
		// command prefix
		builder.setPrefix("$");
		// Add our command(this is now where we register the commands)

		// Bot helps u out. its nice
		builder.setHelpWord("helpme");
		// build the command client

		builder.addCommand(new bonepics());

		CommandClient client = builder.build();

		// We no longer need to register each command class here, we just register the
		// command client
		jda.addEventListener(client);

	}
}
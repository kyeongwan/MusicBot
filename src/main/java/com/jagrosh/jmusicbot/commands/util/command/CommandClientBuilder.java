//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.jagrosh.jmusicbot.commands.util.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

import com.jagrosh.jmusicbot.commands.util.command.impl.AnnotatedModuleCompilerImpl;
import com.jagrosh.jmusicbot.commands.util.command.impl.CommandClientImpl;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class CommandClientBuilder {
    private Activity activity = Activity.playing("default");
    private OnlineStatus status;
    private String ownerId;
    private String[] coOwnerIds;
    private String prefix;
    private String altprefix;
    private String serverInvite;
    private String success;
    private String warning;
    private String error;
    private String carbonKey;
    private String botsKey;
    private final LinkedList<Command> commands;
    private CommandListener listener;
    private boolean useHelp;
    private boolean shutdownAutomatically;
    private Consumer<CommandEvent> helpConsumer;
    private String helpWord;
    private ScheduledExecutorService executor;
    private int linkedCacheSize;
    private AnnotatedModuleCompiler compiler;
    private GuildSettingsManager manager;

    public CommandClientBuilder() {
        this.status = OnlineStatus.ONLINE;
        this.commands = new LinkedList();
        this.useHelp = true;
        this.shutdownAutomatically = true;
        this.linkedCacheSize = 0;
        this.compiler = new AnnotatedModuleCompilerImpl();
        this.manager = null;
    }

    public CommandClient build() {
        CommandClient client = new CommandClientImpl(this.ownerId, this.coOwnerIds, this.prefix, this.altprefix, this.activity, this.status, this.serverInvite, this.success, this.warning, this.error, this.carbonKey, this.botsKey, new ArrayList(this.commands), this.useHelp, this.shutdownAutomatically, this.helpConsumer, this.helpWord, this.executor, this.linkedCacheSize, this.compiler, this.manager);
        if (this.listener != null) {
            client.setListener(this.listener);
        }

        return client;
    }

    public CommandClientBuilder setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public CommandClientBuilder setCoOwnerIds(String... coOwnerIds) {
        this.coOwnerIds = coOwnerIds;
        return this;
    }

    public CommandClientBuilder setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public CommandClientBuilder setAlternativePrefix(String prefix) {
        this.altprefix = prefix;
        return this;
    }

    public CommandClientBuilder useHelpBuilder(boolean useHelp) {
        this.useHelp = useHelp;
        return this;
    }

    public CommandClientBuilder setHelpConsumer(Consumer<CommandEvent> helpConsumer) {
        this.helpConsumer = helpConsumer;
        return this;
    }

    public CommandClientBuilder setHelpWord(String helpWord) {
        this.helpWord = helpWord;
        return this;
    }

    public CommandClientBuilder setServerInvite(String serverInvite) {
        this.serverInvite = serverInvite;
        return this;
    }

    public CommandClientBuilder setEmojis(String success, String warning, String error) {
        this.success = success;
        this.warning = warning;
        this.error = error;
        return this;
    }

    public CommandClientBuilder setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public CommandClientBuilder useDefaultGame() {
        this.activity = Activity.playing("default");
        return this;
    }

    public CommandClientBuilder setStatus(OnlineStatus status) {
        this.status = status;
        return this;
    }

    public CommandClientBuilder addCommand(Command command) {
        this.commands.add(command);
        return this;
    }

    public CommandClientBuilder addCommands(Command... commands) {
        Command[] var2 = commands;
        int var3 = commands.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Command command = var2[var4];
            this.addCommand(command);
        }

        return this;
    }

    public CommandClientBuilder addAnnotatedModule(Object module) {
        this.commands.addAll(this.compiler.compile(module));
        return this;
    }

    public CommandClientBuilder addAnnotatedModules(Object... modules) {
        Object[] var2 = modules;
        int var3 = modules.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object command = var2[var4];
            this.addAnnotatedModule(command);
        }

        return this;
    }

    public CommandClientBuilder setAnnotatedCompiler(AnnotatedModuleCompiler compiler) {
        this.compiler = compiler;
        return this;
    }

    public CommandClientBuilder setCarbonitexKey(String key) {
        this.carbonKey = key;
        return this;
    }

    public CommandClientBuilder setDiscordBotsKey(String key) {
        this.botsKey = key;
        return this;
    }

    /** @deprecated */
    @Deprecated
    public CommandClientBuilder setDiscordBotListKey(String key) {
        return this;
    }

    public CommandClientBuilder setListener(CommandListener listener) {
        this.listener = listener;
        return this;
    }

    public CommandClientBuilder setScheduleExecutor(ScheduledExecutorService executor) {
        this.executor = executor;
        return this;
    }

    public CommandClientBuilder setShutdownAutomatically(boolean shutdownAutomatically) {
        this.shutdownAutomatically = shutdownAutomatically;
        return this;
    }

    public CommandClientBuilder setLinkedCacheSize(int linkedCacheSize) {
        this.linkedCacheSize = linkedCacheSize;
        return this;
    }

    public CommandClientBuilder setGuildSettingsManager(GuildSettingsManager manager) {
        this.manager = manager;
        return this;
    }
}

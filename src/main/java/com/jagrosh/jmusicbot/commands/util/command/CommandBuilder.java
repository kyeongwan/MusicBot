//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.jagrosh.jmusicbot.commands.util.command;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.dv8tion.jda.api.Permission;

public class CommandBuilder {
    private String name = "null";
    private String help = "no help available";
    private Command.Category category = null;
    private String arguments = null;
    private boolean guildOnly = true;
    private String requiredRole = null;
    private boolean ownerCommand = false;
    private int cooldown = 0;
    private Permission[] userPermissions = new Permission[0];
    private Permission[] botPermissions = new Permission[0];
    private final LinkedList<String> aliases = new LinkedList();
    private final LinkedList<Command> children = new LinkedList();
    private BiConsumer<CommandEvent, Command> helpBiConsumer = null;
    private boolean usesTopicTags = true;
    private Command.CooldownScope cooldownScope;
    private boolean hidden;

    public CommandBuilder() {
        this.cooldownScope = Command.CooldownScope.USER;
        this.hidden = false;
    }

    public CommandBuilder setName(String name) {
        if (name == null) {
            this.name = "null";
        } else {
            this.name = name;
        }

        return this;
    }

    public CommandBuilder setHelp(String help) {
        if (help == null) {
            this.help = "no help available";
        } else {
            this.help = help;
        }

        return this;
    }

    public CommandBuilder setCategory(Command.Category category) {
        this.category = category;
        return this;
    }

    public CommandBuilder setArguments(String arguments) {
        this.arguments = arguments;
        return this;
    }

    public CommandBuilder setGuildOnly(boolean guildOnly) {
        this.guildOnly = guildOnly;
        return this;
    }

    public CommandBuilder setRequiredRole(String requiredRole) {
        this.requiredRole = requiredRole;
        return this;
    }

    public CommandBuilder setOwnerCommand(boolean ownerCommand) {
        this.ownerCommand = ownerCommand;
        return this;
    }

    public CommandBuilder setCooldown(int cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public CommandBuilder setUserPermissions(Permission... userPermissions) {
        if (userPermissions == null) {
            this.userPermissions = new Permission[0];
        } else {
            this.userPermissions = userPermissions;
        }

        return this;
    }

    public CommandBuilder setUserPermissions(Collection<Permission> userPermissions) {
        if (userPermissions == null) {
            this.userPermissions = new Permission[0];
        } else {
            this.userPermissions = (Permission[])((Permission[])userPermissions.toArray());
        }

        return this;
    }

    public CommandBuilder setBotPermissions(Permission... botPermissions) {
        if (botPermissions == null) {
            this.botPermissions = new Permission[0];
        } else {
            this.botPermissions = botPermissions;
        }

        return this;
    }

    public CommandBuilder setBotPermissions(Collection<Permission> botPermissions) {
        if (botPermissions == null) {
            this.botPermissions = new Permission[0];
        } else {
            this.botPermissions = (Permission[])((Permission[])botPermissions.toArray());
        }

        return this;
    }

    public CommandBuilder addAlias(String alias) {
        this.aliases.add(alias);
        return this;
    }

    public CommandBuilder addAliases(String... aliases) {
        String[] var2 = aliases;
        int var3 = aliases.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String alias = var2[var4];
            this.addAlias(alias);
        }

        return this;
    }

    public CommandBuilder setAliases(String... aliases) {
        this.aliases.clear();
        if (aliases != null) {
            String[] var2 = aliases;
            int var3 = aliases.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String alias = var2[var4];
                this.addAlias(alias);
            }
        }

        return this;
    }

    public CommandBuilder setAliases(Collection<String> aliases) {
        this.aliases.clear();
        if (aliases != null) {
            this.aliases.addAll(aliases);
        }

        return this;
    }

    public CommandBuilder addChild(Command child) {
        this.children.add(child);
        return this;
    }

    public CommandBuilder addChildren(Command... children) {
        Command[] var2 = children;
        int var3 = children.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Command child = var2[var4];
            this.addChild(child);
        }

        return this;
    }

    public CommandBuilder setChildren(Command... children) {
        this.children.clear();
        if (children != null) {
            Command[] var2 = children;
            int var3 = children.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Command child = var2[var4];
                this.addChild(child);
            }
        }

        return this;
    }

    public CommandBuilder setChildren(Collection<Command> children) {
        this.children.clear();
        if (children != null) {
            this.children.addAll(children);
        }

        return this;
    }

    public CommandBuilder setHelpBiConsumer(BiConsumer<CommandEvent, Command> helpBiConsumer) {
        this.helpBiConsumer = helpBiConsumer;
        return this;
    }

    public CommandBuilder setUsesTopicTags(boolean usesTopicTags) {
        this.usesTopicTags = usesTopicTags;
        return this;
    }

    public CommandBuilder setCooldownScope(Command.CooldownScope cooldownScope) {
        if (cooldownScope == null) {
            this.cooldownScope = Command.CooldownScope.USER;
        } else {
            this.cooldownScope = cooldownScope;
        }

        return this;
    }

    public CommandBuilder setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public Command build(Consumer<CommandEvent> execution) {
        return this.build((c, e) -> {
            execution.accept(e);
        });
    }

    public Command build(final BiConsumer<Command, CommandEvent> execution) {
        return new CommandBuilder.BlankCommand(this.name, this.help, this.category, this.arguments, this.guildOnly, this.requiredRole, this.ownerCommand, this.cooldown, this.userPermissions, this.botPermissions, (String[])this.aliases.toArray(new String[this.aliases.size()]), (Command[])this.children.toArray(new Command[this.children.size()]), this.helpBiConsumer, this.usesTopicTags, this.cooldownScope, this.hidden) {
            protected void execute(CommandEvent event) {
                execution.accept(this, event);
            }
        };
    }

    private abstract class BlankCommand extends Command {
        BlankCommand(String name, String help, Category category, String arguments, boolean guildOnly, String requiredRole, boolean ownerCommand, int cooldown, Permission[] userPermissions, Permission[] botPermissions, String[] aliases, Command[] children, BiConsumer<CommandEvent, Command> helpBiConsumer, boolean usesTopicTags, CooldownScope cooldownScope, boolean hidden) {
            this.name = name;
            this.help = help;
            this.category = category;
            this.arguments = arguments;
            this.guildOnly = guildOnly;
            this.requiredRole = requiredRole;
            this.ownerCommand = ownerCommand;
            this.cooldown = cooldown;
            this.userPermissions = userPermissions;
            this.botPermissions = botPermissions;
            this.aliases = aliases;
            this.children = children;
            this.helpBiConsumer = helpBiConsumer;
            this.usesTopicTags = usesTopicTags;
            this.cooldownScope = cooldownScope;
            this.hidden = hidden;
        }
    }
}

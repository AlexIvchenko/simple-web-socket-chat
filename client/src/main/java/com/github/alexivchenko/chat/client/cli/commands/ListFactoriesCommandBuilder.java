package com.github.alexivchenko.chat.client.cli.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Ivchenko
 */
public class ListFactoriesCommandBuilder implements CommandBuilder {
    private final List<CommandFactory> factories;
    private final Command fallback;

    public static Builder builder() {
        return new Builder();
    }

    private ListFactoriesCommandBuilder(List<CommandFactory> factories, Command fallback) {
        this.factories = new ArrayList<>(factories);
        this.fallback = fallback;
    }

    @Override
    public Command command(String str) {
        for (CommandFactory definition : factories) {
            if (definition.isAvailable()) {
                if (definition.supports(str)) {
                    return definition.build(str);
                }
            }
        }
        return fallback;
    }

    public static class Builder {
        private final List<CommandFactory> factories = new ArrayList<>();
        private Command fallback = () -> {};

        public Builder add(CommandFactory factory) {
            factories.add(factory);
            return this;
        }

        public Builder setFallback(Command fallback) {
            this.fallback = fallback;
            return this;
        }

        public Builder addAdd(List<CommandFactory> factories) {
            factories.addAll(factories);
            return this;
        }

        public CommandBuilder build() {
            return new ListFactoriesCommandBuilder(factories, fallback);
        }
    }
}

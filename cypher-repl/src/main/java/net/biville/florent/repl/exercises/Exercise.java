package net.biville.florent.repl.exercises;

import net.biville.florent.repl.logging.ConsoleLogger;

import java.util.Arrays;
import java.util.Objects;

public class Exercise {

    private final String instructions;
    private final String writeValidationQuery;
    private final byte[] serializedResult;
    private final int position;
    private final int total;

    public Exercise(String instructions,
                    String writeValidationQuery,
                    byte[] serializedResult,
                    int position,
                    int total) {

        this.instructions = instructions;
        this.writeValidationQuery = writeValidationQuery;
        this.serializedResult = serializedResult;
        this.position = position;
        this.total = total;
    }

    public String getInstructions() {
        return instructions;
    }

    public byte[] getSerializedResult() {
        return serializedResult;
    }

    public String getWriteValidationQuery() {
        return writeValidationQuery;
    }

    public int getPosition() {
        return position;
    }

    public int getTotal() {
        return total;
    }

    public boolean requiresWrites() {
        return writeValidationQuery != null;
    }

    public void accept(ConsoleLogger logger) {
        logger.information("");
        logger.information(this.getCurrentPosition());
        logger.information("");
        logger.information(this.getInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructions, Arrays.hashCode(serializedResult));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Exercise other = (Exercise) obj;
        return Objects.equals(this.instructions, other.instructions)
                && Arrays.equals(this.serializedResult, other.serializedResult);
    }

    private String getCurrentPosition() {
        return String.format(".: Exercise %d/%d :.", position, total);
    }
}

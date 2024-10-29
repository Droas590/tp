package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;
import seedu.address.model.role.Role;
import seedu.address.model.wedding.Wedding;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid, please "
            + "enter an index that is between 1 and %1$d";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append(" | Phone: ")
                .append(person.getPhone())
                .append(" | Email: ")
                .append(person.getEmail())
                .append(" | Address: ")
                .append(person.getAddress())
                .append("| Role: ")
                .append(person.getRole().map(Role::toString).orElse(null));
        return builder.toString();
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Wedding wedding) {
        final StringBuilder builder = new StringBuilder();
        builder.append(wedding.getName())
                .append(" | Client: ")
                .append(wedding.getClient().getPerson().getName().fullName)
                .append(" | Date: ")
                .append(wedding.getDate())
                .append(" | Venue: ")
                .append(wedding.getVenue());
        return builder.toString();
    }

}

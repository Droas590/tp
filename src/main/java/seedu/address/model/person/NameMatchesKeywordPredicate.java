package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 * Different from NameContainsKeywordsPredicate as it requires all keywords to be present in the name.
 */
public class NameMatchesKeywordPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public NameMatchesKeywordPredicate(List<String> names) {
        this.keywords = names;
    }

    @Override
    public boolean test(Person person) {
        requireNonNull(person);
        // Return false if keywords list is empty
        if (keywords.isEmpty()) {
            return false;
        }
        return keywords.stream()
                .allMatch(keyword -> person.getName().fullName.toLowerCase().contains(keyword.toLowerCase()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NameMatchesKeywordPredicate)) {
            return false;
        }

        NameMatchesKeywordPredicate otherNameMatchesKeywordPredicate = (NameMatchesKeywordPredicate) other;
        return keywords.equals(otherNameMatchesKeywordPredicate.keywords);
    }

    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}

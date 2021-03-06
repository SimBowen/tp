//@@author Rye98

package seedu.duke.command.favouritecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.FavouriteUi;

public class DeleteFavouriteCommand extends Command {

    protected FavouriteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted favourite route :)";

    public DeleteFavouriteCommand() {
        this.ui = new FavouriteUi();
    }

    public void execute() {
        try {
            ui.showFavourites(favourite);
            int deleteIndex = ui.getDeleteIndex();
            favourite.deleteFavourite(deleteIndex - 1);
            ui.showMessageWithDivider(MESSAGE_SUCCESS);
        } catch (EmptyFavouriteException | InvalidIndexException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}

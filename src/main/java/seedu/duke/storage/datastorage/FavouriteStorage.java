//@@author Rizavur

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class FavouriteStorage extends Storage {

    public FavouriteStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
        storageName = "Favourite";
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeFavourite(favourite);
            Files.write(filepath, encodedData);
        } catch (IOException | InvalidIndexException e) {
            throw new SaveDataException();
        }
    }

    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = decodeHistoryAndFavouriteData(encodedData, nusMap);
                favourite.addFavourite(decodedData[0], decodedData[1]);
            }
        } catch (IOException e) {
            throw new LoadDataException();
        }
    }
}

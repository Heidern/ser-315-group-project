package viewmodels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scarneiro on 11/27/2016.
 */
public class Note {
    public List <NoteTitleAndId> NoteTitles;
    public long CurrentNoteId;
    public String CurrentNoteTitle;
    public String CurrentNoteContents;

    public Note () {
        NoteTitles = new ArrayList<NoteTitleAndId>();
    }
}

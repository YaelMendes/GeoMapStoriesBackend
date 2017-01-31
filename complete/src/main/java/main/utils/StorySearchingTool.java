package main.utils;

import main.story.Story;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yme on 30.01.2017.
 */
public class StorySearchingTool {


    public List<Story> searchBesidedStories(Story refStory, List<Story> stories, int nbKms) {
        return stories.stream()
                .filter(story -> getDistance(story, refStory) <= nbKms)
                .collect(Collectors.toList());
    }

    //TODO
    private int getDistance(Story story, Story refStory) {
        return 0;
    }


}

# Poetweet

## To Run:

### Recommended (But optional) step: Install Tweepy

- This is because the script that fetches tweets relies on tweepy
- If you *really* don't want to install this there are some tweets provided in /resources

```
$ sudo pip install tweepy
```

### To run the first two user stories by the first actor, type the command:

```
gradlew runPoetweet
```

(If you didn't install tweepy you can't do user story 1 (menu option 1))

But you CAN make a haiku with the following twitter handles:

- dog_feelings
- ProBirdRights
- realDonalTrump

### And for the last user story by the second actor, type the command:

```
gradlew runPoetweetAdmin
```



# User Stories

#### As a poet, I want to input a twitter handle so that I can fetch that account's tweets.

##### Acceptance Criteria:

- Given that I know a twitter handle, when I input said twitter handle then the tweets will be pulled and saved to a file.
- Given that I typed the wrong twitter handle, when I input said twitter handle then the system will fail gracefully (and yell at the user).

##### Where to find this:

- TwitterScraper.java

#### As a poet, I want to generate a haiku so that I can have a poem based off a specific twitter user's tweets.

##### Acceptance Criteria:

- Given that I have a file of tweets, when I ask nicely for the system to make me a poem then it will transform tweets into a haiku.

- Given that a file of tweets does not exist, when I generate a poem it will pull the tweets and then make the poem.

  ##### Where to find this:

  - HaikuGnerationOption.java
  - PoemGenerator.java
  - TweetParser.java

#### As a system administrator, I want to be able to clear the files of tweets stored so that I can safely remove old data.

##### Acceptance Criteria:

- Given that I have a folder full of files, when I select this option then all the files will be deleted.

- Given that the folder is empty, when I select this option then nothing will change.

- Given that one of the files in the folder is open, when I select this options then all files but the open one will be deleted.

  ##### Where to find this:

  - ClearResourcesAdminOption.java



# For Grading:

### Where to find Single Responsibility Principle

While I strived to follow this principle in all my classes, the place where this principle has the most impact is in my PoemGenerator class. This is because this class relies on multiple classes (TwitterScraper, TweetParser, and Poem) but changes to either of those three classes won't affect the generation of poems. The Poem can be different types (Haiku, Sonnet, Rondel) but switching out those classes wouldn't affect the generation of the poem. Additionally, changing the functionality of TwitterScraper or TweetParser wouldn't affect PoemGenerator. 

### Where to find Open/Close Principle

- HaikuGenerationOption.java

  - Implements IMenuOption.java but also extends PoemGenerator
  - Extends the functionality of PoemGenerator but Haiku

  PoemGenerator is closed, because it's abstract, but it's open for extension by HaikuGenerationOption.



ALSO FYI THE SYLLABLE COUNTING LIBRARY THAT I USED IS BUGGY :( There's an issue on github about it, don't blame me.
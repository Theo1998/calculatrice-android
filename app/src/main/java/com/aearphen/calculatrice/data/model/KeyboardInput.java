package com.aearphen.calculatrice.data.model;

/**
 * Created by Aearphen on 26/04/18.
 */
public class KeyboardInput {

    private final String characterToDisplay;
    private final String characterReference;

    public KeyboardInput(String characterToDisplay, String characterReference) {
        this.characterToDisplay = characterToDisplay;
        this.characterReference = characterReference;
    }

    public String getCharacterToDisplay() {
        return characterToDisplay;
    }

    public String getCharacterReference() {
        return characterReference;
    }

    @Override
    public String toString() {
        return "KeyboardInput {" + '\n' +
                "\tcharacterToDisplay = '" + characterToDisplay + '\'' + '\n' +
                "\tcharacterReference = '" + characterReference + '\'' + '\n' +
                '}';
    }
}

package com.example.genshinimpactcharacterguide;

import java.util.ArrayList;

public class CharacterData {
    private static String[] characterNames = {
            "Diluc",
            "Keqing",
            "Xiao",
            "Venti",
            "Mona",
            "Klee",
            "Xiangling",
            "Razor",
            "Ningguang",
            "Beidou",
            "Chongyun",
            "Fischl"
    };

    private static String[] characterDetails = {
            "The tycoon of a winery empire in Mondstadt, unmatched in every possible way.",
            "The Yuheng of the Liyue Qixing. Has much to say about Rex Lapis' unilateral approach to policymaking in Liyue - but in truth, gods admire skeptics such as her quite a lot.",
            "A yaksha adeptus that defends Liyue. Also heralded as the \"Conqueror of Demons\" or \"Vigilant Yaksha.\"",
            "One of the many bards of Mondstadt, who freely wanders the city's streets and alleys.",
            "A mysterious young astrologer who proclaims herself to be \"Astrologist Mona Megistus,\" and who possesses abilities to match the title.",
            "An explosives expert and a regular at the Knights of Favonius' confinement room. Also known as Fleeing Sunlight.",
            "A renowned chef from Liyue. She's extremely passionate about cooking and excels at making her signature hot and spicy dishes.",
            "A boy who lives among the wolves in Wolvendom of Mondstadt, away from human civilization. As agile as lightning.",
            "The Tianquan of Liyue Qixing. Her wealth is unsurpassed in all of Teyvat.",
            "Beidou is the leader of the Crux — an armed fleet based in Liyue Harbor. An armed fleet means exactly what it sounds like: a fleet of ships armed to the teeth.",
            "A young exortcist from a family of exorcists. He does everything he can to suppress his pure positive energy.",
            "A mysterious girl who calls herself \"Prinzessia der Verurteilung\" and travels with a night raven named Oz.",
    };

    private static int[] characterImages = {
            R.drawable.diluc,
            R.drawable.keqing,
            R.drawable.xiao,
            R.drawable.venti,
            R.drawable.mona,
            R.drawable.klee,
            R.drawable.xiangling,
            R.drawable.razor,
            R.drawable.ningguang,
            R.drawable.beidou,
            R.drawable.chongyun,
            R.drawable.fischl,
    };

    private static  String[] characterElement = {
            "Pyro",
            "Electro",
            "Anemo",
            "Anemo",
            "Hydro",
            "Pyro",
            "Pyro",
            "Electro",
            "Geo",
            "Electro",
            "Cyro",
            "Electro"
    };

    private static  String[] characterWeapon = {
            "Claymore",
            "Sword",
            "Polearm",
            "Bow",
            "Catalyst",
            "Catalyst",
            "Polearm",
            "Claymore",
            "Catalyst",
            "Claymore",
            "Claymore",
            "Bow"
    };
    static ArrayList<Character> getListData(){
        ArrayList<Character> list = new ArrayList<>();
        for (int position = 0; position < characterNames.length; position++){
            Character character = new Character();
            character.setName(characterNames[position]);
            character.setDetail(characterDetails[position]);
            character.setPhoto(characterImages[position]);
            character.setElement(characterElement[position]);
            character.setWeapon(characterWeapon[position]);
            list.add(character);
        }
        return list;
    }
}

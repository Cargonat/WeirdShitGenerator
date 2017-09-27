
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WeirdShitGenerator
{
    private static WeirdShitGeneratorUI _ui;
    private static boolean _isNotSaved = true;

    private static List<String> _types;
    private static List<String> _origins;
    private static List<String> _compositions;
    private static List<String> _reproductionOrGrowths;
    private static List<String> _specialProperties;
    private static List<String> _verbs;

    public static void main(String[] args)
    {
        
        System.out.println("Testing Git");
        
        createLists();

        _ui = new WeirdShitGeneratorUI();

        registerButtons();
        generate();

        _ui.zeigeFenster();
    }

    private static String getText()
    {
        return "<html><body>This [" + _types.get(0) + "] comes from ["
                + _origins.get(0) + "] and is made of [" + _compositions.get(0)
                + "]. It reproduces or grows via ["
                + _reproductionOrGrowths.get(0) + "]. It ["
                + _specialProperties.get(0) + "] and ["
                + _specialProperties.get(1) + "]. It [" + _verbs.get(0)
                + "] and it [" + _verbs.get(1) + "].</body></html>";
    }

    private static String getSaveText()
    {
        return "This [" + _types.get(0) + "] comes from [" + _origins.get(0)
                + "] and is made of [" + _compositions.get(0)
                + "]. It reproduces or grows via ["
                + _reproductionOrGrowths.get(0) + "]. It ["
                + _specialProperties.get(0) + "] and ["
                + _specialProperties.get(1) + "]. It [" + _verbs.get(0)
                + "] and it [" + _verbs.get(1) + "].";
    }

    private static void shuffleLists()
    {
        Collections.shuffle(_types);
        Collections.shuffle(_origins);
        Collections.shuffle(_compositions);
        Collections.shuffle(_reproductionOrGrowths);
        Collections.shuffle(_specialProperties);
        Collections.shuffle(_verbs);
    }

    private static void generate()
    {
        shuffleLists();
        _ui.setText(getText());
        _isNotSaved = true;
    }

    private static void registerButtons()
    {
        _ui.getGenerateButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    generate();
                }
            });

        _ui.getTypeButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollType();
                }
            });

        _ui.getOriginButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollOrigin();
                }
            });

        _ui.getCompButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollComp();
                }
            });

        _ui.getGrowButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollGrow();
                }
            });

        _ui.getProp1Button()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollProp1();
                }
            });

        _ui.getProp2Button()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollProp2();
                }
            });

        _ui.getVerb1Button()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollVerb1();
                }
            });

        _ui.getVerb2Button()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    rerollVerb2();
                }
            });

        _ui.getSaveButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(_isNotSaved) saveToTxtFile();
                }
            });
    }

    protected static void saveToTxtFile()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String timeStamp = dateFormat.format(date); //2014/08/06 15:59:48
        
        List<String> lines = new ArrayList<String>();
        lines.add(timeStamp);
        lines.add(getSaveText());
        lines.add("");

        _isNotSaved = false;
        
        try
        {
            Files.write(Paths.get("Weird Generated Shit.txt"),
                    lines,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            try
            {
                System.out.println("e");
                Files.write(Paths.get("Weird Generated Shit.txt"),
                        getSaveText().getBytes(), StandardOpenOption.CREATE);
            }
            catch (IOException e1)
            {
                System.out.println("e1");
                e1.printStackTrace();
                _isNotSaved = true;
            }
        }
    }

    protected static void rerollType()
    {
        Collections.shuffle(_types);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollOrigin()
    {
        Collections.shuffle(_origins);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollComp()
    {
        Collections.shuffle(_compositions);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollGrow()
    {
        Collections.shuffle(_reproductionOrGrowths);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollProp1()
    {
        String temp = _specialProperties.get(1);
        do
        {
            Collections.shuffle(_specialProperties);
        }
        while (_specialProperties.get(0) == temp);
        _specialProperties.set(1, temp);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollProp2()
    {
        String temp = _specialProperties.get(0);
        do
        {
            Collections.shuffle(_specialProperties);
        }
        while (_specialProperties.get(1) == temp);
        _specialProperties.set(0, temp);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollVerb1()
    {
        String temp = _verbs.get(1);
        do
        {
            Collections.shuffle(_verbs);
        }
        while (_verbs.get(0) == temp);
        _verbs.set(1, temp);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    protected static void rerollVerb2()
    {
        String temp = _verbs.get(0);
        do
        {
            Collections.shuffle(_verbs);
        }
        while (_verbs.get(1) == temp);
        _verbs.set(0, temp);
        _ui.setText(getText());
        _isNotSaved = true;
    }

    private static void createLists()
    {
        _types = new ArrayList<String>();
        _origins = new ArrayList<String>();
        _compositions = new ArrayList<String>();
        _reproductionOrGrowths = new ArrayList<String>();
        _specialProperties = new ArrayList<String>();
        _verbs = new ArrayList<String>();

        createTypesList();
        createOriginsList();
        createCompositionsList();
        createReproductionOrGrowthsList();
        createSpecialPropertiesList();
        createVerbsList();
    }

    private static void createVerbsList()
    {
        _verbs.add("Abuses");
        _verbs.add("Activates");
        _verbs.add("Ages");
        _verbs.add("Alerts");
        _verbs.add("Analyzes");
        _verbs.add("Arouses");
        _verbs.add("Ascends");
        _verbs.add("Asks");
        _verbs.add("Aspires");
        _verbs.add("Attaches");
        _verbs.add("Attacks");
        _verbs.add("Awakens");
        _verbs.add("Baits");
        _verbs.add("Barks");
        _verbs.add("Basks");
        _verbs.add("Bathes");
        _verbs.add("Bellows");
        _verbs.add("Betrays");
        _verbs.add("Bickers");
        _verbs.add("Bites");
        _verbs.add("Blames");
        _verbs.add("Blinds");
        _verbs.add("Blinks");
        _verbs.add("Blooms");
        _verbs.add("Breaks");
        _verbs.add("Burns");
        _verbs.add("Charms");
        _verbs.add("Climbs");
        _verbs.add("Complicates");
        _verbs.add("Confides");
        _verbs.add("Constructs");
        _verbs.add("Crawls");
        _verbs.add("Cries");
        _verbs.add("Dangles");
        _verbs.add("Darts");
        _verbs.add("Defeats");
        _verbs.add("Detects");
        _verbs.add("Devours");
        _verbs.add("Disrupts");
        _verbs.add("Drifts");
        _verbs.add("Drips");
        _verbs.add("Eats");
        _verbs.add("Echoes");
        _verbs.add("Enjoys");
        _verbs.add("Enllarges");
        _verbs.add("Evaluates");
        _verbs.add("Exites");
        _verbs.add("Explodes");
        _verbs.add("Exposes");
        _verbs.add("Flashes");
        _verbs.add("Flies");
        _verbs.add("Follows");
        _verbs.add("Forgives");
        _verbs.add("Freezes");
        _verbs.add("Gathers");
        _verbs.add("Gnaws");
        _verbs.add("Gurgles");
        _verbs.add("Hastens");
        _verbs.add("Hates");
        _verbs.add("Illuminates");
        _verbs.add("Implodes");
        _verbs.add("Imprisons");
        _verbs.add("Incubates");
        _verbs.add("Leaps");
        _verbs.add("Lies");
        _verbs.add("Limits");
        _verbs.add("Listens");
        _verbs.add("Loves");
        _verbs.add("Mimics");
        _verbs.add("Moans");
        _verbs.add("Mutilates");
        _verbs.add("Mutters");
        _verbs.add("Perceives");
        _verbs.add("Pleases");
        _verbs.add("Plots");
        _verbs.add("Prohibits");
        _verbs.add("Pulses");
        _verbs.add("Purrs");
        _verbs.add("Recites");
        _verbs.add("Refreshes");
        _verbs.add("Refuels");
        _verbs.add("Restrains");
        _verbs.add("Rolls");
        _verbs.add("Rumbles");
        _verbs.add("Scolds");
        _verbs.add("Scours");
        _verbs.add("Screams");
        _verbs.add("Screeches");
        _verbs.add("Serves");
        _verbs.add("Smells");
        _verbs.add("Speaks");
        _verbs.add("Stores");
        _verbs.add("Sucks");
        _verbs.add("Thrives");
        _verbs.add("Transcends");
        _verbs.add("Transforms");
        _verbs.add("Unravels");
        _verbs.add("Vomits");
        _verbs.add("Walks");
        _verbs.add("Writes");
    }

    private static void createSpecialPropertiesList()
    {
        _specialProperties.add("Acts As A Beacon");
        _specialProperties.add("Ages Living Beings");
        _specialProperties.add("Alters A Living Being's Personality");
        _specialProperties.add("Appears Wherever The PCs Are");
        _specialProperties.add("Attracts A Powerful Creature");
        _specialProperties.add("Attracts All Liquid Blood");
        _specialProperties.add("Attracts Swarms Of Rats");
        _specialProperties.add("Becomes The Subject Of Everyone's Dreams");
        _specialProperties.add("Becomes Transparent In Sunlight");
        _specialProperties.add("Bolsters Defenses");
        _specialProperties.add("Brings Memories To Life");
        _specialProperties.add("Causes Weight Loss");
        _specialProperties.add("Causes Comas");
        _specialProperties.add("Causes Critical Failures");
        _specialProperties.add("Causes Critical Successes");
        _specialProperties.add("Causes Earthquakes");
        _specialProperties.add("Causes Explosions");
        _specialProperties.add("Causes Fear");
        _specialProperties.add("Causes Humans To Switch Minds");
        _specialProperties.add("Causes Insanity");
        _specialProperties.add("Causes Intoxication");
        _specialProperties.add("Causes Levitation");
        _specialProperties.add("Causes Limb Regrowth");
        _specialProperties.add("Causes Living Beings To Be Submissive");
        _specialProperties
            .add("Causes Living Beings To Bleed From Every Orifice");
        _specialProperties.add("Causes Permanent Phobias");
        _specialProperties.add("Causes Projectile Vomiting");
        _specialProperties.add("Causes Rapid Hair Growth");
        _specialProperties.add("Causes Rapid Injury Healing");
        _specialProperties.add("Causes Rapid Skin Flaking");
        _specialProperties.add("Causes Severe Fatigue");
        _specialProperties.add("Causes Snow To Fall, Even Indoors");
        _specialProperties.add("Causes Suffocation");
        _specialProperties.add("Causes Total Blindness");
        _specialProperties.add("Causes Tumors To Rapidly Form");
        _specialProperties.add("Causes Unconsciousness");
        _specialProperties.add("Causes Vivid Hallucinations");
        _specialProperties.add("Causes Weight Gain");
        _specialProperties.add("Changes The Perception Of Self");
        _specialProperties.add("Contains/Causes A Portal To Another Place");
        _specialProperties.add("Controls Animals");
        _specialProperties.add("Controls Living Beings");
        _specialProperties.add("Creates Darkness");
        _specialProperties.add("Creates Deserts");
        _specialProperties.add("Creates Insects");
        _specialProperties.add("Cures Insanity");
        _specialProperties.add("Drains Life From Magic Users");
        _specialProperties
            .add("Emanates Banging And Screaming Sounds From Within");
        _specialProperties.add("Emits Thick Smoke");
        _specialProperties.add("Empowers Animals");
        _specialProperties.add("Erases Memories");
        _specialProperties.add("Evokes Extreme Violence In Living Beings");
        _specialProperties.add("Exists Inside Of A Living Being");
        _specialProperties.add("Fills With Mindless Euphoria");
        _specialProperties.add("Freezes When Hot And Thaws When Cold");
        _specialProperties.add("Gives Animals The Power Of Speech");
        _specialProperties.add("Heals Humans");
        _specialProperties.add("Imbues Living Beings");
        _specialProperties.add("With Strength Imprisons Living Beings");
        _specialProperties.add("Increases Probability Of Lucid Dreaming");
        _specialProperties
            .add("Increases The Growth Rate Of Nearby Plant Life");
        _specialProperties.add("Inspires Bloodlust In Humans");
        _specialProperties.add("Is Immortal");
        _specialProperties.add("Is Inhabited By Sentient Beings");
        _specialProperties.add("Is Sentient");
        _specialProperties.add("Is Unbreakable");
        _specialProperties.add("Is Very Alluring");
        _specialProperties.add("Kills With A Touch");
        _specialProperties
            .add("Makes Living Beings Visible Through Solid Materials");
        _specialProperties.add("Makes Weather Patterns Change In Extremes");
        _specialProperties.add("Maximizes Magical Effects");
        _specialProperties.add("Melds Into Living Beings");
        _specialProperties.add("Minimizes Magical Effects");
        _specialProperties.add("Mutates Living Beings");
        _specialProperties.add("Opens Dimensional Gateways");
        _specialProperties.add("Permanently Marks Living Beings");
        _specialProperties.add("Prevents Dehydration");
        _specialProperties.add("Protects Living Beings From Harm");
        _specialProperties.add("Provides Nourishment If Eaten");
        _specialProperties.add("Reacts When Touched By Living Being");
        _specialProperties.add("Repels Entities / Enemies");
        _specialProperties.add("Resurrects The Dead");
        _specialProperties.add("Reverses Magic Targeting");
        _specialProperties.add("Saps Strength From Living Beings");
        _specialProperties.add("Shears Away Limbs");
        _specialProperties.add("Shrinks Living Beings");
        _specialProperties.add("Spawns Creatures");
        _specialProperties.add("Spawns Doppelgangers");
        _specialProperties.add("Spreads Disease");
        _specialProperties.add("Stains Anything It Touches");
        _specialProperties.add("Starts Fires");
        _specialProperties.add("Stops Time");
        _specialProperties.add("Suffocates Living Beings");
        _specialProperties.add("Summons Creatures");
        _specialProperties.add("Teleports Nearby Objects");
        _specialProperties.add("Trees Grow Near It");
        _specialProperties.add("Turns Eyes Entirely Black");
        _specialProperties.add("Turns Flesh To Wood");
        _specialProperties.add("Turns Water Into Acid");
        _specialProperties.add("Twists And Then Grants Wishes");
    }

    private static void createReproductionOrGrowthsList()
    {
        _reproductionOrGrowths.add("Being Struck By Lightning");
        _reproductionOrGrowths.add("Cellular Division");
        _reproductionOrGrowths.add("Choosing A Successor");
        _reproductionOrGrowths
            .add("Commandeering The Production Of Something Else");
        _reproductionOrGrowths.add("Impregnating Humans");
        _reproductionOrGrowths.add("Infecting The Living");
        _reproductionOrGrowths.add("Interdimensional Translocation");
        _reproductionOrGrowths.add("Laying Eggs");
        _reproductionOrGrowths.add("Possessing The Living");
        _reproductionOrGrowths.add("Religious Worship");
        _reproductionOrGrowths.add("The Assistance Of Affected Living Beings");
        _reproductionOrGrowths.add("The Consumption Of The Living");
        _reproductionOrGrowths.add("The Conversion Of Water");
        _reproductionOrGrowths.add("The Creation Of Seeds");
        _reproductionOrGrowths.add("The Disassembly Of Its Environment");
        _reproductionOrGrowths.add("The Syphoning Of Heat Energy");
        _reproductionOrGrowths.add("The Voluntary Sacrifice Of Living Beings");
        _reproductionOrGrowths.add("Time Travel");
        _reproductionOrGrowths.add("Unobserved Methods");
        _reproductionOrGrowths.add("Violently Exploding");
    }

    private static void createCompositionsList()
    {
        _compositions.add("Animal Body Parts");
        _compositions.add("Animal Horn");
        _compositions.add("Blood");
        _compositions.add("Bone");
        _compositions.add("Bread");
        _compositions.add("Brick");
        _compositions.add("Ceramic");
        _compositions.add("Coal");
        _compositions.add("Coins");
        _compositions.add("Coral");
        _compositions.add("Cork");
        _compositions.add("Earth");
        _compositions.add("Fabric");
        _compositions.add("Feathers");
        _compositions.add("Feces");
        _compositions.add("Fire");
        _compositions.add("Flesh");
        _compositions.add("Food");
        _compositions.add("Gears");
        _compositions.add("Glass");
        _compositions.add("Gold");
        _compositions.add("Hair");
        _compositions.add("Human Body Parts");
        _compositions.add("Ice");
        _compositions.add("Lead");
        _compositions.add("Leather");
        _compositions.add("Light");
        _compositions.add("Living People");
        _compositions.add("Memories");
        _compositions.add("Metal");
        _compositions.add("Mold");
        _compositions.add("Music");
        _compositions.add("Organs");
        _compositions.add("Paper");
        _compositions.add("Plant Fibers");
        _compositions.add("Plant-life");
        _compositions.add("Quartz");
        _compositions.add("Salt");
        _compositions.add("Sand");
        _compositions.add("Shadow");
        _compositions.add("Smoke");
        _compositions.add("Soap");
        _compositions.add("Stone");
        _compositions.add("Tumors");
        _compositions.add("Twine");
        _compositions.add("Water");
        _compositions.add("Wax");
        _compositions.add("Wind");
        _compositions.add("Wood");
        _compositions.add("Yarn");
    }

    private static void createOriginsList()
    {
        _origins.add("A Bag Of Holding");
        _origins.add("A Battlefield");
        _origins.add("A Cave Filled With Wonders");
        _origins.add("A Clear Pool Of Water");
        _origins.add("A Closet");
        _origins.add("A Cult's Commune");
        _origins.add("A Dream");
        _origins.add("A Factory");
        _origins.add("A Gutter In An Alley");
        _origins.add("A Haunted House");
        _origins.add("A Hoarder's Closet");
        _origins.add("A Lone Inventor");
        _origins.add("A Madman's Dishelved Home");
        _origins.add("A Meteor");
        _origins.add("A Mine Shaft");
        _origins.add("A Missing House");
        _origins.add("A Mundane Object Which Gained Special Properties");
        _origins.add("A Novel");
        _origins.add("A Pile Of Garbage");
        _origins.add("A Prison");
        _origins.add("A Ship");
        _origins.add("A Small Town");
        _origins.add("A Summoning Circle");
        _origins.add("A Tomb");
        _origins.add("A Tree");
        _origins.add("A Unique Plant That Only Grows In One Place");
        _origins.add("A Warehouse");
        _origins.add("An Abandoned Journal");
        _origins.add("An Abandoned Shrine");
        _origins.add("An Abandoned Warehouse");
        _origins.add("An Asylum");
        _origins.add("Another Dimension");
        _origins.add("Another Planet");
        _origins.add("Inside Of A Dragon");
        _origins.add("Inside Of A Human");
        _origins.add("Outer Space");
        _origins.add("The Bottom Of A Barrel");
        _origins.add("The Bottom Of A Pit Trap");
        _origins.add("The Brain Of A Genius");
        _origins.add("The Center Of A Labyrinth");
        _origins.add("The Clutches Of A Zombie");
        _origins.add("The End Of A Rainbow");
        _origins.add("The Frozen North");
        _origins.add("The Grave Of A Famous Person");
        _origins.add("The Moon");
        _origins.add("The Mysterous East");
        _origins.add("The Savages To The South");
        _origins.add("The Swamp");
        _origins.add("Under The Floorboards");
        _origins.add("Underground");
    }

    private static void createTypesList()
    {
        _types.add("Amulet");
        _types.add("Animal");
        _types.add("Anvil");
        _types.add("Arrow");
        _types.add("Awl");
        _types.add("Baby");
        _types.add("Backpack");
        _types.add("Bag");
        _types.add("Ball");
        _types.add("Bandage");
        _types.add("Bandana");
        _types.add("Bangle");
        _types.add("Banner");
        _types.add("Barding");
        _types.add("Barrel");
        _types.add("Basement");
        _types.add("Basin");
        _types.add("Basket");
        _types.add("Battle Axe");
        _types.add("Bedroll");
        _types.add("Beer");
        _types.add("Belt");
        _types.add("Beret");
        _types.add("Blacksmith tools");
        _types.add("Blanket");
        _types.add("Blouse");
        _types.add("Blowgun");
        _types.add("Bone");
        _types.add("Book");
        _types.add("Boots");
        _types.add("Boulder");
        _types.add("Bow");
        _types.add("Box");
        _types.add("Bracelet");
        _types.add("Bracer");
        _types.add("Brazier");
        _types.add("Bucket");
        _types.add("Buckle");
        _types.add("Cage");
        _types.add("Caltrops");
        _types.add("Candle");
        _types.add("Canteen");
        _types.add("Castle");
        _types.add("Cauldron");
        _types.add("Cave");
        _types.add("Censer");
        _types.add("Chain");
        _types.add("Chalk");
        _types.add("Chest");
        _types.add("Child");
        _types.add("Chisel");
        _types.add("City");
        _types.add("Climbing gear");
        _types.add("Cloak");
        _types.add("Clock");
        _types.add("Cloth");
        _types.add("Clothing");
        _types.add("Club");
        _types.add("Coal");
        _types.add("Coif");
        _types.add("Coin");
        _types.add("Collar");
        _types.add("Comb");
        _types.add("Cork");
        _types.add("Cowbell");
        _types.add("Crate");
        _types.add("Crevasse");
        _types.add("Crib");
        _types.add("Crown");
        _types.add("Crutches");
        _types.add("Cube");
        _types.add("Cuirass");
        _types.add("Cup");
        _types.add("Curtain");
        _types.add("Cushion");
        _types.add("Dagger");
        _types.add("Deck of Cards");
        _types.add("Desk");
        _types.add("Die");
        _types.add("Dirk");
        _types.add("Doll");
        _types.add("Door");
        _types.add("Doorway");
        _types.add("Drawing");
        _types.add("Dress");
        _types.add("Drink");
        _types.add("Drinking Glass");
        _types.add("Drum");
        _types.add("Dungeon");
        _types.add("Earring");
        _types.add("Egg");
        _types.add("Fan");
        _types.add("Farm");
        _types.add("Feather");
        _types.add("Fife");
        _types.add("Flag");
        _types.add("Flint and iron");
        _types.add("Flower");
        _types.add("Flute");
        _types.add("Forest");
        _types.add("Fork");
        _types.add("Garrote");
        _types.add("Gem");
        _types.add("Girdle");
        _types.add("Gloves");
        _types.add("Goblet");
        _types.add("Grappling hook");
        _types.add("Greaves");
        _types.add("Hammer");
        _types.add("Handsaw");
        _types.add("Harp");
        _types.add("Harpoon");
        _types.add("hat");
        _types.add("Hatchet");
        _types.add("Healer's Kit");
        _types.add("Helmet");
        _types.add("Hoe");
        _types.add("Hood");
        _types.add("Hook");
        _types.add("Horn");
        _types.add("Hourglass");
        _types.add("Human Head");
        _types.add("Humanoid");
        _types.add("Incense");
        _types.add("Ingot");
        _types.add("Ink");
        _types.add("Jar");
        _types.add("Javelin");
        _types.add("Jelly");
        _types.add("Jewel");
        _types.add("Juice");
        _types.add("Kettle");
        _types.add("Kettledrum");
        _types.add("Key");
        _types.add("Kite");
        _types.add("Knife");
        _types.add("Kopis");
        _types.add("Ladder");
        _types.add("Ladle");
        _types.add("Lake");
        _types.add("Lamp");
        _types.add("Lantern");
        _types.add("Leather Armor");
        _types.add("Liquid");
        _types.add("Lock");
        _types.add("Lockpicks");
        _types.add("Loom");
        _types.add("Lute");
        _types.add("Mace");
        _types.add("Man");
        _types.add("Manacles");
        _types.add("Mask");
        _types.add("Matchbox");
        _types.add("Medicine");
        _types.add("Mine");
        _types.add("Mirror");
        _types.add("Mitten");
        _types.add("Mold");
        _types.add("Mortar & Pestle");
        _types.add("Mountain");
        _types.add("Mug");
        _types.add("Musical Instrument");
        _types.add("Nail");
        _types.add("Napkin");
        _types.add("Nacklace");
        _types.add("Needle");
        _types.add("Net");
        _types.add("Note");
        _types.add("Novel");
        _types.add("Oil");
        _types.add("Orchard");
        _types.add("Outpost");
        _types.add("Package");
        _types.add("Painting");
        _types.add("Pan");
        _types.add("Pants");
        _types.add("Paper");
        _types.add("Park");
        _types.add("Pick");
        _types.add("Piece of Cake");
        _types.add("Pillow");
        _types.add("Pin");
        _types.add("Pipes");
        _types.add("Pitchfork");
        _types.add("Pocket Knife");
        _types.add("Poem");
        _types.add("Poison");
        _types.add("Pond");
        _types.add("Pot");
        _types.add("Potion");
        _types.add("Pouch");
        _types.add("Preserved Organ");
        _types.add("Prison Cell");
        _types.add("Prybar");
        _types.add("Pyramid");
        _types.add("Quarterstaff");
        _types.add("Quartz");
        _types.add("Quilt");
        _types.add("Quiver");
        _types.add("Rake");
        _types.add("Rations");
        _types.add("Rattle");
        _types.add("Recipe");
        _types.add("Region");
        _types.add("Ribbon");
        _types.add("Ring");
        _types.add("River");
        _types.add("Robe");
        _types.add("Rock");
        _types.add("Rod");
        _types.add("Rolling Pin");
        _types.add("Room");
        _types.add("Rope");
        _types.add("Ruin");
        _types.add("Sabre");
        _types.add("Sack");
        _types.add("Sandals");
        _types.add("Sarcophagus");
        _types.add("Sash");
        _types.add("Satchel");
        _types.add("Saw");
        _types.add("Scabbard");
        _types.add("Scale");
        _types.add("Scarf");
        _types.add("Scimitar");
        _types.add("Sroll");
        _types.add("Scroll case");
        _types.add("Scythe");
        _types.add("Seal");
        _types.add("Sentence");
        _types.add("Series of Numbers");
        _types.add("Shawl");
        _types.add("Shears");
        _types.add("Sheath");
        _types.add("Sheet Music");
        _types.add("Shell");
        _types.add("Shield");
        _types.add("Ship");
        _types.add("Shoes");
        _types.add("Shortsword");
        _types.add("Shovel");
        _types.add("Skirt");
        _types.add("Sling");
        _types.add("Smell");
        _types.add("Soap");
        _types.add("Sound");
        _types.add("Soup");
        _types.add("Spade");
        _types.add("Spear");
        _types.add("Sphere");
        _types.add("Spike");
        _types.add("Spoon");
        _types.add("Spring");
        _types.add("Spring of Water");
        _types.add("Staff");
        _types.add("Statue");
        _types.add("Statuette");
        _types.add("Stick");
        _types.add("Stone");
        _types.add("Stool");
        _types.add("Sundial");
        _types.add("Sword");
        _types.add("Symbol");
        _types.add("Tabard");
        _types.add("Tent");
        _types.add("Thimble");
        _types.add("Tobacco Pipe");
        _types.add("Tongs");
        _types.add("Torch");
        _types.add("Totem");
        _types.add("Towel");
        _types.add("Town");
        _types.add("Tray");
        _types.add("Tree");
        _types.add("Trident");
        _types.add("Tunic");
        _types.add("Unknown Machinery");
        _types.add("Vase");
        _types.add("Vault");
        _types.add("Vest");
        _types.add("Vial");
        _types.add("Vice");
        _types.add("Village");
        _types.add("Virus");
        _types.add("Volcano");
        _types.add("Wagon");
        _types.add("Wand");
        _types.add("War Hammer");
        _types.add("Warship");
        _types.add("Waterskin");
        _types.add("Well");
        _types.add("Whetstone");
        _types.add("Whip");
        _types.add("Whistle");
        _types.add("Windchime");
        _types.add("Window");
        _types.add("Wine");
        _types.add("Woman");
        _types.add("Wrench");
        _types.add("Writing Equipment");
    }

}

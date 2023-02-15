
import java.util.Scanner;
import java.util.StringTokenizer;

public class caesarCipher {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println(""); //prompts input :
            System.out.println("Do you want to encode (e), decode (d), bruteforce (b) or quit (q)?");
            char choice = kbd.nextLine().charAt(0); //takes only the first character of their input, so if they even put in the word "bruteforce", itll still take it as 'b'

            String input = "";
            int shifter = 0; //set amount shifted to 0 by default

            switch (choice) {
                case 'e': //            -- encoding --
                    while (input.isEmpty() || shifter > 25 || shifter < 1) { //keep prompting if they input an empty string, or shift thats not between 1-25
                        System.out.println("Input the phrase you want to encode, followed by the offset you want to offset it by");
                        System.out.print("Phrase to encode: "); //prompts input phrase
                        input = kbd.nextLine();
                        System.out.print("Amount to shift by: "); //prompts the amount that the phrase will be shifted
                        shifter = Integer.parseInt(kbd.nextLine());
                        if (input.isEmpty() || shifter > 25 || shifter < 1) { //if string was empty, or shift not between 1-25, tell the user before repromting
                            System.out.println("Either the input was empty, or the shift wasnt a number between 1-25");
                        }
                    }
                    System.out.println("Encoded message: " + encode(input, shifter)); //run the encoder with the inputs given
                    break;

                case 'd': //            -- decoding --
                    while (input.isEmpty() || shifter > 25 || shifter < 1) { //keep prompting if they input an empty string, or shift thats not between 1-25
                        System.out.println("Input the phrase you want to decode, followed by the offset you want to offset it by");
                        System.out.print("Encoded phrase: "); //prompts input phrase
                        input = kbd.nextLine();
                        System.out.print("Amount to shift by: "); //prompts amount left that the phrase will be shifted
                        shifter = 26 - Integer.parseInt(kbd.nextLine()); //sets the decoding shifter to 26 minus their inputted left shift, so itll act as its moving left, even though its moving right
                        if (input.isEmpty() || shifter > 25 || shifter < 1) { //if string was empty, or shift not between 1-25, tell the user before repromting
                            System.out.println("Either the input was empty, or the shift wasnt a number between 1-25");
                        }
                    }
                    System.out.println("Decoded message: " + encode(input, shifter)); //runs the encoder with the decoder inputs given
                    break;

                case 'b'://            -- bruteforcing --
                    System.out.println("Input the phrase you want to try to bruteforce"); //prompts input
                    input = kbd.nextLine();
                    String bruteforceOutputArray[] = bruteforce(input); //sets output array to the array given when running the bruteforce
                    for(int i=0;i<=26;i++){ //prints out all 26 outputs and the best combination given
                        System.out.println(bruteforceOutputArray[i]);
                    }
                    break;

                case 'q': //quits out of loop
                    loop = false;
                    System.out.println("See you later :)");
                    break;

                default: //if input was not q, b, d, or e, tell user and run again
                    System.out.println("'" + choice + "' is not one of the options.");
                    break;

            }
        }

    }

    public static String encode(String input, int shifter) { // puts in a string and a shift to run through the cypher, and encode your string by that shift
        String output = "";
        for (int i = 0; input.length() > i; i++) { //run through the entire string inputted
            char currentChar = input.charAt(i);

            if (currentChar >= 65 && currentChar <= 90) { //if the character is capital
                if ((currentChar + shifter) > 90) { //if shifted letter is going past Z
                    output += (char) (64 + (currentChar + shifter - 90)); //output if character would be past Z
                } else {
                    output += (char) (currentChar + shifter); //output with normal shift
                }

            } else if (currentChar >= 97 && currentChar <= 122) { //if the character is lowercase
                if ((currentChar + shifter) > 122) { //if the shifted letter is going past z
                    output += (char) (96 + (currentChar + shifter - 122)); //output if character would be past z
                } else {
                    output += (char) (currentChar + shifter); //output with normal shift
                }

            } else {
                output += currentChar; //output if the character is not an alphabetical value (keeps spaces, symbols, and numbers the same)
            }

        }
        return output;

    }

    private static String[] bruteforce(String input) { //bruteforces the encoded input and returns all of the possible option, as well as the best option
        int highscore = -100;
        String highscorer = "";
        String bruteforceArray[] = new String[27];
        int bruteforceWeight[] = new int[26];
        //Array of the top 1000 most common english words:
        String mostCommonWords[] = {" a ", " i ", " the ", " be ", " and ", " a ", " of ", " to ", " in ", " i ", " you ", " it ", " have ", " to ", " that ", " for ", " do ", " he ", " with ", " on ", " this ", " not ", " we ", " that ", " not ", " but ", " they ", " say ", " at ", " what ", " his ", " from ", " go ", " or ", " by ", " get ", " she ", " my ", " can ", " as ", " know ", " if ", " me ", " your ", " all ", " who ", " about ", " their ", " will ", " so ", " would ", " make ", " just ", " up ", " think ", " time ", " there ", " see ", " her ", " as ", " out ", " one ", " come ", " people ", " take ", " year ", " him ", " them ", " some ", " want ", " how ", " when ", " which ", " now ", " like ", " other ", " could ", " our ", " into ", " here ", " then ", " than ", " look ", " way ", " more ", " these ", " no ", " thing ", " well ", " because ", " also ", " two ", " use ", " tell ", " good ", " first ", " man ", " day ", " find ", " give ", " more ", " new ", " one ", " us ", " any ", " those ", " very ", " her ", " need ", " back ", " there ", " should ", " even ", " only ", " many ", " really ", " work ", " life ", " why ", " right ", " down ", " on ", " try ", " let ", " something ", " too ", " call ", " woman ", " may ", " still ", " through ", " mean ", " after ", " never ", " no ", " world ", " in ", " feel ", " yeah ", " great ", " last ", " child ", " oh ", " over ", " ask ", " when ", " as ", " school ", " state ", " much ", " talk ", " out ", " keep ", " leave ", " put ", " like ", " help ", " big ", " where ", " same ", " all ", " own ", " while ", " start ", " three ", " high ", " every ", " another ", " become ", " most ", " between ", " happen ", " family ", " over ", " president ", " old ", " yes ", " house ", " show ", " again ", " student ", " so ", " seem ", " might ", " part ", " hear ", " its ", " place ", " problem ", " where ", " believe ", " country ", " always ", " week ", " point ", " hand ", " off ", " play ", " turn ", " few ", " group ", " such ", " against ", " run ", " guy ", " about ", " case ", " question ", " work ", " night ", " live ", " game ", " number ", " write ", " bring ", " without ", " money ", " lot ", " most ", " book ", " system ", " government ", " next ", " city ", " company ", " story ", " today ", " job ", " move ", " must ", " bad ", " friend ", " during ", " begin ", " love ", " each ", " hold ", " different ", " american ", " little ", " before ", " ever ", " word ", " fact ", " right ", " read ", " anything ", " nothing ", " sure ", " small ", " month ", " program ", " maybe ", " right ", " under ", " business ", " home ", " kind ", " stop ", " pay ", " study ", " since ", " issue ", " name ", " idea ", " room ", " percent ", " far ", " away ", " law ", " actually ", " large ", " though ", " provide ", " lose ", " power ", " kid ", " war ", " understand ", " head ", " mother ", " real ", " best ", " team ", " eye ", " long ", " long ", " side ", " water ", " young ", " wait ", " okay ", " both ", " yet ", " after ", " meet ", " service ", " area ", " important ", " person ", " hey ", " thank ", " much ", " someone ", " end ", " change ", " however ", " only ", " around ", " hour ", " everything ", " national ", " four ", " line ", " girl ", " around ", " watch ", " until ", " father ", " sit ", " create ", " information ", " car ", " learn ", " least ", " already ", " kill ", " minute ", " party ", " include ", " stand ", " together ", " back ", " follow ", " health ", " remember ", " often ", " reason ", " speak ", " ago ", " set ", " black ", " member ", " community ", " once ", " social ", " news ", " allow ", " win ", " body ", " lead ", " continue ", " whether ", " enough ", " spend ", " level ", " able ", " political ", " almost ", " boy ", " university ", " before ", " stay ", " add ", " later ", " change ", " five ", " probably ", " center ", " among ", " face ", " public ", " die ", " food ", " else ", " history ", " buy ", " result ", " morning ", " off ", " parent ", " office ", " course ", " send ", " research ", " walk ", " door ", " white ", " several ", " court ", " home ", " grow ", " better ", " open ", " moment ", " including ", " consider ", " both ", " such ", " little ", " within ", " second ", " late ", " street ", " free ", " better ", " everyone ", " policy ", " table ", " sorry ", " care ", " low ", " human ", " please ", " hope ", " true ", " process ", " teacher ", " data ", " offer ", " death ", " whole ", " experience ", " plan ", " easy ", " education ", " build ", " expect ", " fall ", " himself ", " age ", " hard ", " sense ", " across ", " show ", " early ", " college ", " music ", " appear ", " mind ", " class ", " police ", " use ", " effect ", " season ", " tax ", " heart ", " son ", " art ", " possible ", " serve ", " break ", " although ", " end ", " market ", " even ", " air ", " force ", " require ", " foot ", " up ", " listen ", " agree ", " according ", " anyone ", " baby ", " wrong ", " love ", " cut ", " decide ", " republican ", " full ", " behind ", " pass ", " interest ", " sometimes ", " security ", " eat ", " report ", " control ", " rate ", " local ", " suggest ", " report ", " nation ", " sell ", " action ", " support ", " wife ", " decision ", " receive ", " value ", " base ", " pick ", " phone ", " thanks ", " event ", " drive ", " strong ", " reach ", " remain ", " explain ", " site ", " hit ", " pull ", " church ", " model ", " perhaps ", " relationship ", " six ", " fine ", " movie ", " field ", " raise ", " less ", " player ", " couple ", " million ", " themselves ", " record ", " especially ", " difference ", " light ", " development ", " federal ", " former ", " role ", " pretty ", " myself ", " view ", " price ", " effort ", " nice ", " quite ", " along ", " voice ", " finally ", " department ", " either ", " toward ", " leader ", " because ", " photo ", " wear ", " space ", " project ", " return ", " position ", " special ", " million ", " film ", " need ", " major ", " type ", " town ", " article ", " road ", " form ", " chance ", " drug ", " economic ", " situation ", " choose ", " practice ", " cause ", " happy ", " science ", " join ", " teach ", " early ", " develop ", " share ", " yourself ", " carry ", " clear ", " brother ", " matter ", " dead ", " image ", " star ", " cost ", " simply ", " post ", " society ", " picture ", " piece ", " paper ", " energy ", " personal ", " building ", " military ", " open ", " doctor ", " activity ", " exactly ", " american ", " media ", " miss ", " evidence ", " product ", " realize ", " save ", " arm ", " technology ", " catch ", " comment ", " look ", " term ", " color ", " cover ", " describe ", " guess ", " choice ", " source ", " mom ", " soon ", " director ", " international ", " rule ", " campaign ", " ground ", " election ", " face ", " uh ", " check ", " page ", " fight ", " itself ", " test ", " patient ", " produce ", " certain ", " whatever ", " half ", " video ", " support ", " throw ", " third ", " care ", " rest ", " recent ", " available ", " step ", " ready ", " opportunity ", " official ", " oil ", " call ", " organization ", " character ", " single ", " current ", " likely ", " county ", " future ", " dad ", " whose ", " less ", " shoot ", " industry ", " second ", " list ", " general ", " stuff ", " figure ", " attention ", " forget ", " risk ", " no ", " focus ", " short ", " fire ", " dog ", " red ", " hair ", " point ", " condition ", " wall ", " daughter ", " before ", " deal ", " author ", " truth ", " upon ", " husband ", " period ", " series ", " order ", " officer ", " close ", " land ", " note ", " computer ", " thought ", " economy ", " goal ", " bank ", " behavior ", " sound ", " deal ", " certainly ", " nearly ", " increase ", " act ", " north ", " well ", " blood ", " culture ", " medical ", " ok ", " everybody ", " top ", " difficult ", " close ", " language ", " window ", " response ", " population ", " lie ", " tree ", " park ", " worker ", " draw ", " plan ", " drop ", " push ", " earth ", " cause ", " per ", " private ", " tonight ", " race ", " than ", " letter ", " other ", " gun ", " simple ", " course ", " wonder ", " involve ", " hell ", " poor ", " each ", " answer ", " nature ", " administration ", " common ", " no ", " hard ", " message ", " song ", " enjoy ", " similar ", " congress ", " attack ", " past ", " hot ", " seek ", " amount ", " analysis ", " store ", " defense ", " bill ", " like ", " cell ", " away ", " performance ", " hospital ", " bed ", " board ", " protect ", " century ", " summer ", " material ", " individual ", " recently ", " example ", " represent ", " fill ", " state ", " place ", " animal ", " fail ", " factor ", " natural ", " sir ", " agency ", " usually ", " significant ", " help ", " ability ", " mile ", " statement ", " entire ", " democrat ", " floor ", " serious ", " career ", " dollar ", " vote ", " sex ", "piss", "compare ", " south ", " forward ", " subject ", " financial ", " identify ", " beautiful ", " decade ", " bit ", " reduce ", " sister ", " quality ", " quickly ", " act ", " press ", " worry ", " accept ", " enter ", " mention ", " sound ", " thus ", " plant ", " movement ", " scene ", " section ", " treatment ", " wish ", " benefit ", " interesting ", " west ", " candidate ", " approach ", " determine ", " resource ", " claim ", " answer ", " prove ", " sort ", " enough ", " size ", " somebody ", " knowledge ", " rather ", " hang ", " sport ", " tv ", " loss ", " argue ", " left ", " note ", " meeting ", " skill ", " card ", " feeling ", " despite ", " degree ", " crime ", " that ", " sign ", " occur ", " imagine ", " vote ", " near ", " king ", " box ", " present ", " figure ", " seven ", " foreign ", " laugh ", " disease ", " lady ", " beyond ", " discuss ", " finish ", " design ", " concern ", " ball ", " east ", " recognize ", " apply ", " prepare ", " network ", " huge ", " success ", " district ", " cup ", " name ", " physical ", " growth ", " rise ", " hi ", " standard ", " force ", " sign ", " fan ", " theory ", " staff ", " hurt ", " legal ", " september ", " set ", " outside ", " et ", " strategy ", " clearly ", " property ", " lay ", " final ", " authority ", " perfect ", " method ", " region ", " since ", " impact ", " indicate ", " safe ", " committee ", " supposed ", " dream ", " training ", " central ", " option ", " eight ", " particularly ", " completely ", " opinion ", " main ", " ten ", " interview ", " exist ", " remove ", " dark ", " play ", " union ", " professor ", " pressure ", " purpose ", " stage ", " blue ", " herself ", " sun ", " pain ", " artist ", " employee ", " avoid ", " account ", " release ", " fund ", " environment ", " treat ", " specific ", " version ", " shot ", " hate ", " reality ", " visit ", " club ", " justice ", " river ", " brain ", " memory ", " rock ", " talk ", " camera ", " global ", " various ", " arrive ", " notice ", " bit ", " detail ", " challenge ", " argument ", " lot ", " nobody ", " weapon ", " best ", " station ", " island ", " absolutely ", " instead ", " discussion ", " instead ", " affect ", " design ", " little ", " anyway ", " respond ", " control ", " trouble ", " conversation ", " manage ", " close ", " date ", " public ", " army ", " top ", " post ", " charge", "seat"};
        //Array of the most common suffixes, and most common n-grams 1-4 (n-grams are the most common character combinations that appear in english text):
        String mostCommonInstances[] = {"th", "ar", "he", "te", "an", "se", "in", "me", "er", "sa", "nd", "ne", "re", "wa", "ed", "ve", "es", "le", "ou", "no", "to", "ta", "ha", "al", "en", "de", "ea", "ot", "st", "so", "nt", "dt", "on", "at", "hi", "el", "as", "ro", "it", "ad", "ng", "di", "is", "ew", "or", "ra", "et", "ri", "of", "sh", "ti", "th", "he", "in", "en", "nt", "re", "er", "an", "ti", "es", "on", "at", "se", "nd", "or", "ar", "al", "te", "co", "de", "to", "ra", "et", "ed", "it", "sa", "em", "ro”,”the", "and", "tha", "ent", "ing", "ion", "tio", "for", "nde", "has", "nce", "edt", "tis", "oft", "sth", "men", "that", "ther", "with", "tion", "here", "ould", "ight", "have", "hich", "whic", "this", "thin", "they", "atio", "ever", "from", "ough", "were", "hing", "ment", "ed", "ing", "ion", "ist", "ous", "ent", "able", "ment", "tion", "ight", "ance"};
        //Array of the most improbable letter combinations in the english language, as well as any one letter word that isnt 'I' or 'A':
        String leastCommonInstances[] = {" b ", " c ", " d ", " e ", " f ", " g ", " h ", " j ", " k ", " l ", " m ", " n ", " o ", " p ", " q ", " r ", " s ", " t ", " u ", " v ", " w ", " x ", " y ", " z ", "bq", "bz", "cf", "cj", "cv", "cx", "fq", "fv", "fx", "fz", "gq", "gv", "gx", "hx", "hz", "jb", "jd", "jf", "jg", "jh", "jl", "jm", "jp", "jq", "jr", "js", "jt", "jv", "jw", "jx", "jy", "jz", "kq", "kx", "kz", "mx", "mz", "pq", "pv", "px", "qa", "qb", "qc", "qd", "qe", "qf", "qg", "qh", "qi", "qj", "qk", "ql", "qm", "qn", "qo", "qp", "qq", "qr", "qs", "qt", "qv", "qw", "qx", "qy", "qz", "sx", "tq", "vb", "vf", "vh", "vj", "vk", "vm", "vp", "vq", "vw", "vx", "wq", "wv", "wx", "xd", "xj", "xk", "xr", "xz", "yq", "yy", "zf", "zr", "zx", "bx", "cj", "cv", "cx", "dx", "fq", "fx", "gq", "gx", "hx", "jc", "jf", "jg", "jq", "js", "jv", "jw", "jx", "jz", "kq", "kx", "mx", "px", "pz", "qb", "qc", "qd", "qf", "qg", "qh", "qj", "qk", "ql", "qm", "qn", "qp", "qs", "qt", "qv", "qw", "qx", "qy", "qz", "sx", "vb", "vf", "vh", "vj", "vm", "vp", "vq", "vt", "vw", "vx", "wx", "xj", "xx", "zj", "zq", "zx", "bx", "cj", "cv", "cx", "dx", "fq", "fx", "gq", "gx", "hx", "jc", "jf", "jg", "jp", "jq", "js", "jv", "jw", "jx", "jz", "kq", "kx", "kz", "mx", "px", "pz", "qb", "qc", "qd", "qf", "qg", "qh", "qj", "qk", "ql", "qm", "qn", "qp", "qs", "qt", "qv", "qw", "qx", "qy", "qz", "sx", "vb", "vd", "vf", "vg", "vh", "vj", "vm", "vp", "vq", "vt", "vw", "vx", "wv", "wx", "xj", "xx", "zj", "zq", "zx", "bx", "cj", "cv", "cx", "dx", "fq", "fx", "gq", "gx", "hx", "jc", "jf", "jg", "jq", "jv", "jx", "jz", "kx", "mx", "px", "qb", "qc", "qd", "qf", "qg", "qj", "qk", "ql", "qm", "qn", "qp", "qt", "qv", "qx", "qy", "qz", "sx", "vb", "vf", "vj", "vm", "vp", "vq", "vt", "vw", "vx", "wx", "xj", "xx", "zx"};

        for (int i = 0; i < 26; i++) { //goes through all 26 combinations
            String currentCombination = encode(input, 26 - i); //encode first combination
            bruteforceArray[i] = ("shifted right " + i + ": " + currentCombination);

            StringTokenizer currentCombinationTokens = new StringTokenizer(currentCombination, " "); //tokenize current combination
            int stringWordLength = currentCombinationTokens.countTokens();
            for (int ii = 0; ii < stringWordLength; ii++) { //checks to see if there are any words without vowels, which is very improbable to be in the decyphered code:

                String currentWord = currentCombinationTokens.nextElement().toString();// if no vowel in word, -10 weight
                if (currentWord.toLowerCase().contains("a") || currentWord.toLowerCase().contains("e") || currentWord.toLowerCase().contains("i") || currentWord.toLowerCase().contains("o") || currentWord.toLowerCase().contains("u") || currentWord.toLowerCase().contains("y")) {
                } else {
                    bruteforceWeight[i] -= 10; //lowers the weight of this combination by 10
                }
            }

            for (int ii = 0; ii < mostCommonWords.length; ii++) { //checks if the string contains one of the most common instances items, which should mostly occur in the decyphered code
                if (currentCombination.toLowerCase().contains(mostCommonWords[ii])) {
                    bruteforceWeight[i] += 5; //raises the weight of this combination by 1
                }
            }
            for (int ii = 0; ii < mostCommonInstances.length; ii++) { //checks if the string contains one of the most common instances items, which should mostly occur in the decyphered code
                if (currentCombination.toLowerCase().contains(mostCommonInstances[ii])) {
                    bruteforceWeight[i]++; //raises the weight of this combination by 1
                }
            }
            for (int ii = 0; ii < leastCommonInstances.length; ii++) { //checks if the string has any impossible 2 letter combinations, which wont appear in the decyphered code
                if (currentCombination.toLowerCase().contains(leastCommonInstances[ii])) {
                    bruteforceWeight[i] -= 3; //lowers the weight of this combination by 3
                }
            }

            if (bruteforceWeight[i] > highscore) { //sets the new most probable decypher based on which combination has the highest weight
                highscorer = bruteforceArray[i];
                highscore = bruteforceWeight[i];
            }
        }
        System.out.println();
        bruteforceArray[26] = ("the best combination is " + highscorer); //sets the last space of the array to the highscorer string

        return bruteforceArray;
    }
}

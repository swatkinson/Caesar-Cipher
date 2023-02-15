# Caesar-Cipher
## A program that can encode, decode, and bruteforce any string or encoded ceasar cipher string




A Caesar cipher is a simple encryption technique that involves shifting each letter in a message a certain number of positions down the alphabet. For example, if you shift each letter in the message by three positions, the letter "A" would be replaced by the letter "D", "B" would become "E", and so on.

---
Here's an example of a Caesar cipher using a shift of 3:

Original message: "HELLO WORLD"
Encrypted message: "KHOOR ZRUOG"

In this example, each letter in the original message has been shifted three positions down the alphabet. The letter "H" has been replaced by "K", the letter "E" has been replaced by "H", and so on.

To decrypt the message, you would simply shift each letter in the opposite direction. If you shift each letter in the encrypted message by three positions up the alphabet, you would recover the original message.

---

In my program, the inputted string is encoded up the alphabet by the inputted number, while keeping capital letters capital, lowercase letters lowercase, and symbols as they are.

To decode, it runs the encode method but backwards, to return the original message.

The Bruteforce method is done in a series of steps

It first creates a weight for each of the 26 possible combinations made by a ceasar cypher.

Weight ups:
-I've input the 1000 most commonly used english words, and instances of those words within the string with sagnificantly increase its weight

-Then i've input the most common n-grams (di-grams, tri-grams, and quadro-grams), which are the most common series of letters to appear in words (such as sh, th, ch, ee, oo), and increases that strings weight

Weight downs:
-It checks to see if the string has words in it that don't include vowels, as those are extremely improbable to be in common sentances, and lowers the weight

-It then checks the least common n-grams, which are least commonly appearing series of letters that appear in words (such as bq, xz, gq and so on) and lowers the weight of that string

Whichever string has the highest weight at the end is the decyphered code! With the integration of n-grams, it even happens to work in a lot of cases with other latin-based languages!)


---

## An example output from my Java program:
```
Do you want to encode (e), decode (d), bruteforce (b) or quit (q)?
e

Input the phrase you want to encode, followed by the offset you want to offset it by
Phrase to encode: Hello world! This is a sample of the ceasar cipher program
Amount to shift by: 3
Encoded message: Khoor zruog! Wklv lv d vdpsoh ri wkh fhdvdu flskhu surjudp

Do you want to encode (e), decode (d), bruteforce (b) or quit (q)?
b
Input the phrase you want to try to bruteforce
Khoor zruog! Wklv lv d vdpsoh ri wkh fhdvdu flskhu surjudp

shifted right 0: Khoor zruog! Wklv lv d vdpsoh ri wkh fhdvdu flskhu surjudp   [-57]
shifted right 1: Jgnnq yqtnf! Vjku ku c ucorng qh vjg egcuct ekrjgt rtqitco   [-99]
shifted right 2: Ifmmp xpsme! Uijt jt b tbnqmf pg uif dfbtbs djqifs qsphsbn   [-129]
shifted right 3: Hello world! This is a sample of the ceasar cipher program   [144]
shifted right 4: Gdkkn vnqkc! Sghr hr z rzlokd ne sgd bdzrzq bhogdq oqnfqzl   [-162]
shifted right 5: Fcjjm umpjb! Rfgq gq y qyknjc md rfc acyqyp agnfcp npmepyk   [-129]
shifted right 6: Ebiil tloia! Qefp fp x pxjmib lc qeb zbxpxo zfmebo moldoxj   [-87]
shifted right 7: Dahhk sknhz! Pdeo eo w owilha kb pda yawown yeldan lnkcnwi   [-33]
shifted right 8: Czggj rjmgy! Ocdn dn v nvhkgz ja ocz xzvnvm xdkczm kmjbmvh   [-141]
shifted right 9: Byffi qilfx! Nbcm cm u mugjfy iz nby wyumul wcjbyl jlialug   [-72]
shifted right 10: Axeeh phkew! Mabl bl t ltfiex hy max vxtltk vbiaxk ikhzktf  [-75]
shifted right 11: Zwddg ogjdv! Lzak ak s ksehdw gx lzw uwsksj uahzwj hjgyjse  [-96]
shifted right 12: Yvccf nficu! Kyzj zj r jrdgcv fw kyv tvrjri tzgyvi gifxird  [-96]
shifted right 13: Xubbe mehbt! Jxyi yi q iqcfbu ev jxu suqiqh syfxuh fhewhqc  [-57]
shifted right 14: Wtaad ldgas! Iwxh xh p hpbeat du iwt rtphpg rxewtg egdvgpb  [-42]
shifted right 15: Vszzc kcfzr! Hvwg wg o goadzs ct hvs qsogof qwdvsf dfcufoa  [-138]
shifted right 16: Uryyb jbeyq! Guvf vf n fnzcyr bs gur prnfne pvcure cebtenz  [-51]
shifted right 17: Tqxxa iadxp! Ftue ue m emybxq ar ftq oqmemd oubtqd bdasdmy  [-78]
shifted right 18: Spwwz hzcwo! Estd td l dlxawp zq esp npldlc ntaspc aczrclx  [-69]
shifted right 19: Rovvy gybvn! Drsc sc k ckwzvo yp dro mokckb mszrob zbyqbkw  [-63]
shifted right 20: Qnuux fxaum! Cqrb rb j bjvyun xo cqn lnjbja lryqna yaxpajv  [-108]
shifted right 21: Pmttw ewztl! Bpqa qa i aiuxtm wn bpm kmiaiz kqxpmz xzwoziu  [-60]
shifted right 22: Olssv dvysk! Aopz pz h zhtwsl vm aol jlhzhy jpwoly wyvnyht  [-93]
shifted right 23: Nkrru cuxrj! Znoy oy g ygsvrk ul znk ikgygx iovnkx vxumxgs  [-81]
shifted right 24: Mjqqt btwqi! Ymnx nx f xfruqj tk ymj hjfxfw hnumjw uwtlwfr  [-156]
shifted right 25: Lipps asvph! Xlmw mw e weqtpi sj xli giewev gmtliv tvskveq  [-63]
the best combination is Hello world! This is a sample of the ceasar cipher program

Do you want to encode (e), decode (d), bruteforce (b) or quit (q)?
d

Input the phrase you want to decode, followed by the offset you want to offset it by
Encoded phrase: Khoor zruog! Wklv lv d vdpsoh ri wkh fhdvdu flskhu surjudp
Amount to shift by: 3
Decoded message: Hello world! This is a sample of the ceasar cipher program

Do you want to encode (e), decode (d), bruteforce (b) or quit (q)?
q


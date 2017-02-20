## Decathlon (test task)

Run program: 
App.java, with arguments: decathlon.csv decathlonExtra.csv outputFinal.xml

also, optional system parameter: -Dxslt=decathlon.xsl
Doubleclicked output file will open browser with applied xslt transformation for nicer view (works on IE, Safari. Chrome seems to block for security reasons).



Expanding Application in terms of more types of games - in case of games without calculated points resulting in totalScore - Athlete entity should be refactored by transfering totalScore field to a more concrete subclass for game type with calculated points.

A Builder DP might be applied for DecathlonAthlete.
I'm not proud of DecathlonPointsCounter.java:5 static wildcard import, but had no choice.
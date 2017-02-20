<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>SwedBank: Decathlon</title>
                <meta charset="utf-8"></meta>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            </head>
            <body>
                <div class="container">
                    <h2>Decathlon Results</h2>
                    <p>The results of processed Decathlon athletes data:</p>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Rank (Place)</th>
                                <th>Total Score</th>
                                <th>100m</th>
                                <th>Long Jump</th>
                                <th>Shot Put</th>
                                <th>High Jump</th>
                                <th>400m</th>
                                <th>110m hurdles</th>
                                <th>Discus Throw</th>
                                <th>Pole Vault</th>
                                <th>Javelin Throw</th>
                                <th>1500m</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="Decathlon/DecathlonAthletes/Athlete">
                                <tr>
                                    <td>
                                        <xsl:value-of select="@name"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="rank"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="TotalScore"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="m100"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="LongJump"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="ShotPut"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="HighJump"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="m400"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="m110"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="DiscusThrow"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="PoleVault"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="JavelinThrow"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="m1500"/>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
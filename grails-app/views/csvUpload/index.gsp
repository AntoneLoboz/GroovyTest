<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>upload csv file</h1>

        <div id="controllers" role="navigation">
            <h2>upload csv:</h2>
            <ul>
                <g:uploadForm controller="CsvUpload" method="POST" action="upload">
                    <input type="file" name="file"/>
                    <g:submitButton name="Submit" value="Submit" />
                </g:uploadForm>
            </ul>
        </div>
    </section>
</div>

</body>
</html>

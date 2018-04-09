<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style>
    .errorList {
        word-break: break-all;
    }
    </style>
</head>
<body>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>upload csv errors</h1>

        <div id="controllers" role="navigation">
            <h2>csv errors:</h2>
            <ul class="errorList">
                <g:each in="${parsErrors}" var="it">
                    <li>${it}</li>
                </g:each>
            </ul>
        </div>
    </section>
</div>

</body>
</html>

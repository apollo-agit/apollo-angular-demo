<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Ian's Apollo Item Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
	
  <link href="css/apollo-item-bootstrap.min.css" rel="stylesheet">
  <link href="css/apollo-item-angular.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.css" rel="stylesheet">
<!--   <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/redmond/jquery-ui.css" rel="stylesheet"> -->

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
   
   <script type="text/javascript" src="js/apollo-item-bootstrap.min.js"></script>
   
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>

   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-resource.min.js"></script>
   
   <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui-ieshiv.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui/0.4.0/angular-ui.min.js"></script>
   
   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
   <script src="http://malsup.github.io/jquery.blockUI.js"></script>
   
   <script src="https://cdnjs.cloudflare.com/ajax/libs/api-check/7.2.2/api-check.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-formly/6.3.4/formly.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-formly-templates-bootstrap/4.0.9/angular-formly-templates-bootstrap.min.js"></script>
   
   <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid-layout.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid-flexible-height.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid-reorderable.min.js"></script>


  <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.14/angular-ui-router.min.js"></script>
   <script type="text/javascript" src="js/apollo-item-angular.js"></script>
 
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Ian's Apollo Item Page</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control" autocomplete="off" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control" autocomplete="off" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div>
      </div>
    </nav>
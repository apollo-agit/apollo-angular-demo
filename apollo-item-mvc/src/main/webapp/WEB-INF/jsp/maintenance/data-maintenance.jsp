<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="row" ng-app="apolloMaintenanceApp">
<div class="row clearfix">
	<div class="jumbotron">
		<div class="container">
			<h1>Ian's Apollo Item Page</h1>
			<p>This is the starting text for the Apollo stuff. Need to add
				verbiage that will describe the solution.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a>
			</p>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-10">
	<ul class="nav nav-pills">
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="item">Property Item Maintenance</a></li>
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="newitem">Home Item Maintenance</a></li>
	</ul>
	</div>
</div>

<div class="row">
<div class="col-md-2"></div>
	<div class="col-md-8 column">
		<div ui-view></div>
	</div>
	<div class="col-md-2"></div>
</div>
</div>




<%@ include file="/WEB-INF/jsp/footer.jsp"%>
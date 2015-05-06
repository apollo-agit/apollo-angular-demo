

/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */


var apolloHistoryServices = angular.module('apolloHistoryServices',	[ 'ngResource' ]);

var apolloItemServices = angular.module('apolloItemServices', [ 'ngResource' ]);

var apolloMaintenanceControllers = angular.module('apolloMaintenanceControllers', []);


var apolloMaintenanceApp = angular.module('apolloMaintenanceApp', [ 'apolloMaintenanceControllers', 'ui.router', 'ngGrid',  
		'apolloItemServices', 'apolloHistoryServices' ]);

apolloMaintenanceApp.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('item', {
		url : '/item',
		templateUrl : 'html/maintenance/item-list.html',
		controller : 'ApolloItemMaintenanceController'
	}).state('history', {
		url : '/history/:itemId',
		templateUrl : 'html/maintenance/item-history.html',
		controller : 'ApolloHistoryController'
	}).state('newitem', {
		url : '/newitem',
		templateUrl : 'html/maintenance/item-new-form.html',
		controller : 'ApolloNewItemController'
	});
	
} ]);

apolloMaintenanceApp.directive("dynamicName",function($compile){
    return {
        restrict:"A",
        terminal:true,
        priority:1000,
        link:function(scope,element,attrs){
            element.attr('name', scope.$eval(attrs.dynamicName));
            element.removeAttr("dynamic-name");
            $compile(element)(scope);
        }
    }
});
/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */

apolloItemServices.factory('ApolloItems', [ '$resource', function($resource) {
	return $resource('/apollo-item-mvc/service/apolloitems/item', {id:'@id'}, {
		query : {
			method : 'GET',
			isArray : true
		},
		save : {
			method:'POST'
		},
		remove : {
			method: 'DELETE'
		}
	});
}]);

var removeTemplate = '<input type="button" value="remove" ng-click="removeRow($index)" />';

var linkCellTemplate = '<a ng-href="#/history/{{row.entity.id}}">{{row.entity.id}}</a>';

apolloMaintenanceControllers.controller('ApolloItemMaintenanceController', [
		'$scope', 'ApolloItems', function($scope, ApolloItems) {
			$scope.apolloItems = ApolloItems.query();
			$scope.orderProp = 'apolloItemName';
			$scope.totalServerItems = $scope.apolloItems.length;
			
			    $scope.gridOptions = { 
			        data: 'apolloItems',
			        columnDefs: [{field:'id', displayName:'Item Id',  cellTemplate: linkCellTemplate},
			                     {field:'apolloItemName', displayName:'Item Name', enableCellEdit: true}, 
			                     {field:'apolloItemAmount', displayName:'Item Cost', enableCellEdit: true},
			                     {field:'apolloItemDesc', displayName:'Item Description', enableCellEdit: true},
			                     {field: 'remove', displayName: '', cellTemplate: removeTemplate}],
			        showGroupPanel: false,
			        jqueryUITheme: true,
			        enablePaging: false,
			        showFooter: true,
			        enableCellSelection: true,
			        enableRowSelection: true,
			        plugins: [new ngGridFlexibleHeightPlugin({ maxHeight : 1000})]
			    };
			    
			 $scope.addRow = function() {
			      $scope.apolloItems.push({apolloItemName: 'Empty', apolloItemAmount: 0});
			 };
			 		 
			 $scope.saveAllApolloItems = function() {
				 $.blockUI({ message: '<h1><img src="images/busy.gif" /> Just a moment...</h1>' }); 
				 angular.forEach($scope.apolloItems, function(value, index){
					 ApolloItems.save({id:value.id}, value);
				 });

				 //hack for visual
				 setTimeout(function(){
					 $.unblockUI(); 
				  }, 2000);
			 };
			 
			 $scope.removeRow = function() {
				 $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
				  var index = this.row.rowIndex;
				  var value = $scope.apolloItems[index];
                  ApolloItems.remove({id:value.id}, value, function(index){
                	  $scope.apolloItems = ApolloItems.query();
                  });
                  
                  //hack for visual
 				 setTimeout(function(){
 					 $.unblockUI(); 
 				  }, 1000);
			 };

		}]);



/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */


apolloItemServices.factory('ApolloNewItem', [ '$resource', function($resource) {
	return $resource('/apollo-item-mvc/service/apolloitems/item', {id:'@id'}, {
		head : {
			url : '/apollo-item-mvc/service/apolloitems/item/metadata',
			method: 'GET'
		}
	});
}]);


apolloMaintenanceControllers.controller('ApolloNewItemController', [
		'$scope', 'ApolloNewItem', function($scope, ApolloNewItem) {
					
			 $scope.loadProperties = function() {
				 ApolloNewItem.head().$promise.then(
						 function( head ){
					        	var myArray = new Array();;
					        	 $.each(head.properties, function(key, value) {
					        		 var field = new Object();
					        		 field.label = key;
					        		 field.name = key;
					        		 field.type = value.type;
					        		 field.required = true;
					        		 myArray.push(field);
					        	 });
					        	var formFields = new Object();
					        	formFields.name = "FormFields";
					        	formFields.fields = myArray;
					        	console.log(JSON.stringify(formFields));
					        	$scope.entity = formFields;
							 }
							);
			 };
				 
			
		}]);
/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */

apolloItemServices.factory('ApolloHistory', [ '$resource', function($resource) {
	return $resource('/apollo-item-mvc/service/apolloitems/history', {itemId : '@historyItemId'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

apolloMaintenanceControllers.controller('ApolloHistoryController', [ '$scope', '$stateParams', 'ApolloHistory', 
        function($scope, $stateParams, ApolloHistory) {
			$scope.historyItemId=$stateParams.itemId;
			$scope.itemHistory=ApolloHistory.query({itemId:$scope.historyItemId});

		} ]);


/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. License: MIT
 */ 

    // unblock when ajax activity stops
    $(document).ajaxStop($.unblockUI); 
 
    function test() { 
        $.ajax({ url: 'wait.php', cache: false }); 
    } 

    $(document).ready(function() { 
    	
 
    $(document).ready(function() { 
        $('#saveAllItems2').click(function() { 
            $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
        }); 
    });
    
    });
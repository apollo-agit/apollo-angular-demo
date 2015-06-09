

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
		'apolloItemServices', 'apolloHistoryServices', 'formly', 'formlyBootstrap']);

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
	return $resource('/service/apolloitems/item', {id:'@id'}, {
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
	return $resource('/service/apolloitems/item', {id:'@id'}, {
		head : {
			url : '/service/apolloitems/item/metadata',
			method: 'GET'
		},
		submit : {
			method : 'POST'
		}
	});
}]);


apolloMaintenanceControllers.controller('ApolloNewItemController', [
		'$scope', 'ApolloNewItem', function($scope, ApolloNewItem) {
			var vm = this;
			vm.apolloItem = {};
			
			vm.submit = function() {
				ApolloNewItem.submit({id:vm.apolloItem.id}, vm.apolloItem).$promise.then(
						function(successResult) {
							vm.apolloItem = result;
					    }, function(errorResult) {
					        alert(errorResult);
					    });
			}
			
			 $scope.loadProperties = function() {
				 ApolloNewItem.head().$promise.then(
						 function( head ){
							 vm.formFields = apollo.generateFields(head);
							 });
			 };
				 
			
		}]);
/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */

apolloItemServices.factory('ApolloHistory', [ '$resource', function($resource) {
	return $resource('/service/apolloitems/history', {itemId : '@historyItemId'}, {
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
        $('#saveAllItems').click(function() { 
            $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
        }); 
    });
    
    });
    
    String.prototype.replaceAll = function (find, replace) {
        var str = this;
        return str.replace(new RegExp(find, 'g'), replace);
    };

    var apollo = {
    		
    		generateFields : function(schema) {
    			var index=0;
    			var formFields = new Array();
    			
    			 $.each(schema.properties, function(key, value) {
            		var formField = new Object();
            		formField.templateOptions = new Object();
            		
            		formField.key = key;
            		
            		switch(value.type) {
            			case 'string':
            				formField.type = 'input';
            				break;
            			case 'text':
            				formField.type = 'textarea';
            				formField.templateOptions.rows = 4;
            				formField.templateOptions.cols = 15;
            				break;
            			case 'id':
            				formField.type = 'input';
            				formField.templateOptions.disabled = 'true';
            				break;
            			default:
            				formField.type = 'input';
            		}
            		
            		formField.templateOptions.required = value.required;
            		formField.templateOptions.label = key.replaceAll("_", " ");        		
            		
            		formFields[index++] = formField;
            	 });
    			 
    			 return formFields;
    		}
    		
    };
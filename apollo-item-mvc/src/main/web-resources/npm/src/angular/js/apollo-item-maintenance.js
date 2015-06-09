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



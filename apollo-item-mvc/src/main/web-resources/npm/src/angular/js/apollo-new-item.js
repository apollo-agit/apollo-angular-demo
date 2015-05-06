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
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
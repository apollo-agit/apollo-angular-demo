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
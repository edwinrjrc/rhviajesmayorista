var appmenu = angular.module('menuapp', []);

appmenu.directive('menuApp',[function(){
	return {
		restrict: 'E',
		templateUrl: 'resources/include/menu.html'
	};
}] );
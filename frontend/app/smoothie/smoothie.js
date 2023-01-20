'use strict';

angular.module('myApp.smoothie', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/smoothie', {
    templateUrl: 'smoothie/smoothie.html',
    controller: 'SmoothieCtrl'
  });
}])

.controller('SmoothieCtrl', function($scope) {
  $scope.smoothie = {
    name: "Spinach",
    ingredients: [
      "Spinach",
      "Milk",
      "Apples",
      "Something"
    ]
  }
});
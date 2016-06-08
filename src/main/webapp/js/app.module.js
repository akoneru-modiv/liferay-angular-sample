var phoneCatApp = angular.module('phoneCatApp', ['ngRoute','phoneList']);

phoneCatApp.controller('PhoneListController', function PhoneListController($scope){
    $scope.phones = [
    {
      name: 'Nexus S',
      snippet: 'Fast just got faster with Nexus S'
    },{
      name: 'Motorola XOOM with wi-if',
      snippet: 'The Next, Next generation tablet.'
    },{
      name: 'Motorola XOOM',
      snippet: 'The Next, Next generation tablet.'
    }];
});
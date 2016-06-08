'use strict';

angular.
    module('phoneList').
    component('phoneList', {
       templateUrl: PhoneConfig.phoneListTemplate,
       controller: ['$http', function PhoneListController($http){
           var self = this;
           var data = {accountId: '9557850', accountType: 'P'};
           console.log(PhoneConfig.ajaxUrl + "&p_p_resource_id=testList");
           $http({
               method: 'GET',
               url: PhoneConfig.ajaxUrl + "&p_p_resource_id=testList",
               params: data
           }).then(function(response){
               self.transactions = response.data;
           });
       }]
    });
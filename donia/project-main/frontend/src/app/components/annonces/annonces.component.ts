import { Component } from '@angular/core';

@Component({
  selector: 'app-annonces',
  templateUrl: './annonces.component.html',
  styleUrls: ['./annonces.component.css']
})
export class AnnoncesComponent {
  cards = [
    {
      title: 'wall-paint',
      date: '01/01/2022',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras facilisis lacus in lorem pulvinar, at eleifend sem imperdiet. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras malesuada justo vitae libero dictum, eget tincidunt augue facilisis. Pellentesque nec sem at erat auctor consequat. Nullam vestibulum sapien eget ligula tincidunt, eget fermentum metus pulvinar. Curabitur ut semper mi, eu feugiat augue. Duis facilisis turpis quis ligula lobortis, non auctor erat lobortis. Nullam sed libero a libero venenatis venenatis id enim. Suspendisse aliquet metus ut orci ultricies, a facilisis libero fermentum. Integer ut leo lacinia, lobortis turpis eu, scelerisque metus. Quisque dapibus sapien a elit viverra, ac ultricies mi ultricies. Nullam eu neque sapien. Etiam congue lacinia semper. Cras mollis massa quis lectus convallis, eu mollis augue tempor. Mauris congue orci sed mauris pulvinar, non tincidunt purus lobortis. Pellentesque auctor sapien ut sem facilisis, ac tincidunt metus feugiat. Curabitur aliquet lacinia enim, a facilisis metus fermentum nec. Suspendisse eget sem vitae ligula tincidunt malesuada et et lectus. Duis tincidunt justo ac elit ultricies, nec consequat est commodo. Nullam mollis lacus eu augue tempus, eget tempor massa consectetur. Vivamus commodo orci ut lorem consectetur, eget dignissim libero fermentum. Mauris dignissim massa ut velit facilisis, non sollicitudin erat commodo. Nullam ullamcorper velit ut lorem tempus, ac posuere metus auctor. Vivamus ac arcu auctor, malesuada justo vitae, venenatis enim. Nullam ultricies enim quis libero faucibus, ac ultricies mi accumsan. In non arcu ut turpis bibendum ultricies a odio. Aenean ut arcu ut lacus tempus eleifend. Nullam lobortis sapien vitae mauris dignissim, et convallis mauris imperdiet. Mauris quis velit ut erat ultricies convallis non ligula. In et est non metus dapibus convallis at sapien. Pellentesque et lorem eget lectus malesuada pulvinar at libero. Cras vitae lorem ut urna bibendum commodo.'
    },
    {
      title: 'fixation tv',
      date: '02/01/2022',
      description: 'Ut ultricies ligula ac ligula ultricies, et auctor lectus commodo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer auctor purus ac enim venenatis, nec sollicitudin lectus posuere. Curabitur facilisis lorem non leo ultricies, non consequat neque sollicitudin. Duis ut est lacinia, posuere massa a, auctor mi. Curabitur ultricies dolor ut tellus interdum, eget lobortis urna bibendum. Suspendisse in semper orci. Duis sagittis massa ac ligula malesuada, et facilisis erat venenatis. Duis sollicitudin elit eget orci consequat, at consequat mi auctor. Duis sit amet lorem nisi. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer aliquet massa sed ex pellentesque, ac elementum mi consectetur. Integer sollicitudin eget sapien eu bibendum. Nullam elementum lorem quis elit bibendum, nec faucibus augue posuere. Mauris facilisis velit a elit viverra, vitae tincidunt massa pulvinar. Integer sit amet mauris eu erat feugiat consectetur.'
    }
 ];

 showDescription = [];

 toggleDescription(index) {
  this.showDescription[index] = !this.showDescription[index];
 }
}



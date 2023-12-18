import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnauthnavComponent } from './unauthnav.component';

describe('UnauthnavComponent', () => {
  let component: UnauthnavComponent;
  let fixture: ComponentFixture<UnauthnavComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UnauthnavComponent]
    });
    fixture = TestBed.createComponent(UnauthnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

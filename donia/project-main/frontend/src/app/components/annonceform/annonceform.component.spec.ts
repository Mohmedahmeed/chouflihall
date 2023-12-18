import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnonceformComponent } from './annonceform.component';

describe('AnnonceformComponent', () => {
  let component: AnnonceformComponent;
  let fixture: ComponentFixture<AnnonceformComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnnonceformComponent]
    });
    fixture = TestBed.createComponent(AnnonceformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

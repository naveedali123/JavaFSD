import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PorfolioPageComponent } from './porfolio-page.component';

describe('PorfolioPageComponent', () => {
  let component: PorfolioPageComponent;
  let fixture: ComponentFixture<PorfolioPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PorfolioPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PorfolioPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

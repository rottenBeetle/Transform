import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranslateFormComponent } from './translate-form.component';

describe('TranslateFormComponent', () => {
  let component: TranslateFormComponent;
  let fixture: ComponentFixture<TranslateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TranslateFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TranslateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

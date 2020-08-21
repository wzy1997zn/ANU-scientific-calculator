package au.edu.anu.scientificcalculator.grid;
import au.edu.anu.scientificcalculator.parser.CalculateCore;
import au.edu.anu.scientificcalculator.parser.FunctionExp;
import au.edu.anu.scientificcalculator.parser.WrongExpressionException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class grid extends View implements View.OnTouchListener{
    public float[] pointY = null;
    public String functionExp = null;
    public float maxValue = 0;
    float widthParameter;
    float heightParameter;
    float diagramWidth;
    float diagramHeight;
    float diagramLeft;
    float diagramTop;

    public grid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Initialize(canvas);
        Print(canvas);
    }

    void Initialize(Canvas canvas){
        FunctionExp exp = null;
        try {
            exp = CalculateCore.getInstance().generateFunction(functionExp);
        }
        catch ( WrongExpressionException e) {
            e.printStackTrace();
        }
        float[] results = exp.getArrayOfY(-10,(int)(20 / 0.001f));

        for(float point:results){
            if(point > maxValue){
                maxValue = point;
            }
        }

        widthParameter = (float)canvas.getWidth();
        heightParameter = (float)canvas.getHeight();
        diagramHeight =  2 * maxValue + 6;
        if(maxValue>=100){
            diagramHeight = 200;
        }
        diagramWidth = 20;
        diagramLeft = -10;
        diagramTop = diagramHeight/2;
        pointY = exp.getArrayOfY(diagramLeft,(int)(diagramWidth / 0.001f)+1);
    }

    public void Print(Canvas canvas){
        //new a paint
        Paint myPaint=new Paint();
        //paint color
        myPaint.setColor(Color.BLACK);
        myPaint.setStrokeWidth(2);
        renderDiagram(canvas,myPaint);
    }
    void renderDiagram(Canvas canvas,Paint paint){
        float widthInterval = diagramLeft+diagramWidth;
        float heightInterval = diagramTop - diagramHeight;
        canvas.drawLine(regulateX(diagramLeft),regulateY(0),regulateX(widthInterval),regulateY(0),paint);
        canvas.drawLine(regulateX(0),regulateY(diagramTop),regulateX(0),regulateY(heightInterval),paint);
        paint.setTextSize(50f);
        canvas.drawText("0",regulateX(0f)+50,regulateY(0f)+50,paint);
        for(float x=diagramLeft; x<widthInterval; x+=0.001f){
            float y = pointY[(int)((x-diagramLeft)/0.001f)];
            canvas.drawPoint(regulateX(x),regulateY(y),paint);
        }
    }
    float regulateX(float x){
        return (x-diagramLeft) * widthParameter/diagramWidth;
    }
    float regulateY(float y){
        return (diagramTop-y) * heightParameter/diagramHeight;
    }
}


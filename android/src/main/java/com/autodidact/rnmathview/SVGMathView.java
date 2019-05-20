package com.autodidact.rnmathview;

import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGImageView;
import com.caverock.androidsvg.SVGParseException;
import com.facebook.react.uimanager.ThemedReactContext;

public class SVGMathView extends View {
    private static String TAG = "RNSVGMathView";
    private SVG mSVG;
    private Picture picture;
    public SVGMathView(ThemedReactContext context){
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        parse(svg);
    }

    public void parse(String svg){
        try{
            mSVG = SVG.getFromString(svg);
            mSVG.setRenderDPI(getResources().getDisplayMetrics().xdpi);
            mSVG.setDocumentPreserveAspectRatio(PreserveAspectRatio.LETTERBOX);
            mSVG.setDocumentWidth("100%");
            mSVG.setDocumentHeight("100%");

            ViewGroup.LayoutParams params = getLayoutParams();
            params.width = (int)(41.848 * 6);
            params.height = (int)(2.843 * 6);
            setLayoutParams(params);

            picture = mSVG.renderToPicture();
        }
        catch (SVGParseException err){
            err.printStackTrace();
            Log.e(TAG, "SVGMathView: Failed to parse svg");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(picture != null) canvas.drawPicture(picture);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //mSVG.setDocumentWidth(w);
        //mSVG.setDocumentHeight(h);
    }

    //width="41.848ex" height="2.843ex"
    static String svg="<svg xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"41.848ex\" height=\"2.843ex\" style=\"vertical-align: -0.838ex;\" viewBox=\"0 -863.1 18017.8 1223.9\" role=\"img\" focusable=\"false\" xmlns=\"http://www.w3.org/2000/svg\" aria-labelledby=\"MathJax-SVG-1-Title\"><title id=\"MathJax-SVG-1-Title\">\\\\sin \\\\left(\\\\alpha \\\\pm \\\\beta \\\\right)=\\\\sin \\\\left(\\\\alpha \\\\right)\\\\cos \\\\left(\\\\beta \\\\right)\\\\pm \\\\cos \\\\left(\\\\alpha \\\\right)\\\\sin \\\\left(\\\\beta \\\\right)</title><defs aria-hidden=\"true\"><path stroke-width=\"1\" id=\"E1-MJMAIN-73\" d=\"M295 316Q295 356 268 385T190 414Q154 414 128 401Q98 382 98 349Q97 344 98 336T114 312T157 287Q175 282 201 278T245 269T277 256Q294 248 310 236T342 195T359 133Q359 71 321 31T198 -10H190Q138 -10 94 26L86 19L77 10Q71 4 65 -1L54 -11H46H42Q39 -11 33 -5V74V132Q33 153 35 157T45 162H54Q66 162 70 158T75 146T82 119T101 77Q136 26 198 26Q295 26 295 104Q295 133 277 151Q257 175 194 187T111 210Q75 227 54 256T33 318Q33 357 50 384T93 424T143 442T187 447H198Q238 447 268 432L283 424L292 431Q302 440 314 448H322H326Q329 448 335 442V310L329 304H301Q295 310 295 316Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-69\" d=\"M69 609Q69 637 87 653T131 669Q154 667 171 652T188 609Q188 579 171 564T129 549Q104 549 87 564T69 609ZM247 0Q232 3 143 3Q132 3 106 3T56 1L34 0H26V46H42Q70 46 91 49Q100 53 102 60T104 102V205V293Q104 345 102 359T88 378Q74 385 41 385H30V408Q30 431 32 431L42 432Q52 433 70 434T106 436Q123 437 142 438T171 441T182 442H185V62Q190 52 197 50T232 46H255V0H247Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-6E\" d=\"M41 46H55Q94 46 102 60V68Q102 77 102 91T102 122T103 161T103 203Q103 234 103 269T102 328V351Q99 370 88 376T43 385H25V408Q25 431 27 431L37 432Q47 433 65 434T102 436Q119 437 138 438T167 441T178 442H181V402Q181 364 182 364T187 369T199 384T218 402T247 421T285 437Q305 442 336 442Q450 438 463 329Q464 322 464 190V104Q464 66 466 59T477 49Q498 46 526 46H542V0H534L510 1Q487 2 460 2T422 3Q319 3 310 0H302V46H318Q379 46 379 62Q380 64 380 200Q379 335 378 343Q372 371 358 385T334 402T308 404Q263 404 229 370Q202 343 195 315T187 232V168V108Q187 78 188 68T191 55T200 49Q221 46 249 46H265V0H257L234 1Q210 2 183 2T145 3Q42 3 33 0H25V46H41Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-28\" d=\"M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z\"></path><path stroke-width=\"1\" id=\"E1-MJMATHI-3B1\" d=\"M34 156Q34 270 120 356T309 442Q379 442 421 402T478 304Q484 275 485 237V208Q534 282 560 374Q564 388 566 390T582 393Q603 393 603 385Q603 376 594 346T558 261T497 161L486 147L487 123Q489 67 495 47T514 26Q528 28 540 37T557 60Q559 67 562 68T577 70Q597 70 597 62Q597 56 591 43Q579 19 556 5T512 -10H505Q438 -10 414 62L411 69L400 61Q390 53 370 41T325 18T267 -2T203 -11Q124 -11 79 39T34 156ZM208 26Q257 26 306 47T379 90L403 112Q401 255 396 290Q382 405 304 405Q235 405 183 332Q156 292 139 224T121 120Q121 71 146 49T208 26Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-B1\" d=\"M56 320T56 333T70 353H369V502Q369 651 371 655Q376 666 388 666Q402 666 405 654T409 596V500V353H707Q722 345 722 333Q722 320 707 313H409V40H707Q722 32 722 20T707 0H70Q56 7 56 20T70 40H369V313H70Q56 320 56 333Z\"></path><path stroke-width=\"1\" id=\"E1-MJMATHI-3B2\" d=\"M29 -194Q23 -188 23 -186Q23 -183 102 134T186 465Q208 533 243 584T309 658Q365 705 429 705H431Q493 705 533 667T573 570Q573 465 469 396L482 383Q533 332 533 252Q533 139 448 65T257 -10Q227 -10 203 -2T165 17T143 40T131 59T126 65L62 -188Q60 -194 42 -194H29ZM353 431Q392 431 427 419L432 422Q436 426 439 429T449 439T461 453T472 471T484 495T493 524T501 560Q503 569 503 593Q503 611 502 616Q487 667 426 667Q384 667 347 643T286 582T247 514T224 455Q219 439 186 308T152 168Q151 163 151 147Q151 99 173 68Q204 26 260 26Q302 26 349 51T425 137Q441 171 449 214T457 279Q457 337 422 372Q380 358 347 358H337Q258 358 258 389Q258 396 261 403Q275 431 353 431Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-29\" d=\"M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-3D\" d=\"M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-63\" d=\"M370 305T349 305T313 320T297 358Q297 381 312 396Q317 401 317 402T307 404Q281 408 258 408Q209 408 178 376Q131 329 131 219Q131 137 162 90Q203 29 272 29Q313 29 338 55T374 117Q376 125 379 127T395 129H409Q415 123 415 120Q415 116 411 104T395 71T366 33T318 2T249 -11Q163 -11 99 53T34 214Q34 318 99 383T250 448T370 421T404 357Q404 334 387 320Z\"></path><path stroke-width=\"1\" id=\"E1-MJMAIN-6F\" d=\"M28 214Q28 309 93 378T250 448Q340 448 405 380T471 215Q471 120 407 55T250 -10Q153 -10 91 57T28 214ZM250 30Q372 30 372 193V225V250Q372 272 371 288T364 326T348 362T317 390T268 410Q263 411 252 411Q222 411 195 399Q152 377 139 338T126 246V226Q126 130 145 91Q177 30 250 30Z\"></path></defs><g stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" transform=\"matrix(1 0 0 -1 0 0)\" aria-hidden=\"true\"><use xlink:href=\"#E1-MJMAIN-73\"></use><use xlink:href=\"#E1-MJMAIN-69\" x=\"394\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-6E\" x=\"673\" y=\"0\"></use><g transform=\"translate(1229,0)\"><use xlink:href=\"#E1-MJMAIN-28\" x=\"0\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B1\" x=\"389\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-B1\" x=\"1252\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B2\" x=\"2252\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-29\" x=\"2826\" y=\"0\"></use></g><use xlink:href=\"#E1-MJMAIN-3D\" x=\"4723\" y=\"0\"></use><g transform=\"translate(5779,0)\"><use xlink:href=\"#E1-MJMAIN-73\"></use><use xlink:href=\"#E1-MJMAIN-69\" x=\"394\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-6E\" x=\"673\" y=\"0\"></use></g><g transform=\"translate(7008,0)\"><use xlink:href=\"#E1-MJMAIN-28\" x=\"0\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B1\" x=\"389\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-29\" x=\"1030\" y=\"0\"></use></g><g transform=\"translate(8595,0)\"><use xlink:href=\"#E1-MJMAIN-63\"></use><use xlink:href=\"#E1-MJMAIN-6F\" x=\"444\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-73\" x=\"945\" y=\"0\"></use></g><g transform=\"translate(9934,0)\"><use xlink:href=\"#E1-MJMAIN-28\" x=\"0\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B2\" x=\"389\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-29\" x=\"963\" y=\"0\"></use></g><use xlink:href=\"#E1-MJMAIN-B1\" x=\"11509\" y=\"0\"></use><g transform=\"translate(12510,0)\"><use xlink:href=\"#E1-MJMAIN-63\"></use><use xlink:href=\"#E1-MJMAIN-6F\" x=\"444\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-73\" x=\"945\" y=\"0\"></use></g><g transform=\"translate(13849,0)\"><use xlink:href=\"#E1-MJMAIN-28\" x=\"0\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B1\" x=\"389\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-29\" x=\"1030\" y=\"0\"></use></g><g transform=\"translate(15435,0)\"><use xlink:href=\"#E1-MJMAIN-73\"></use><use xlink:href=\"#E1-MJMAIN-69\" x=\"394\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-6E\" x=\"673\" y=\"0\"></use></g><g transform=\"translate(16665,0)\"><use xlink:href=\"#E1-MJMAIN-28\" x=\"0\" y=\"0\"></use><use xlink:href=\"#E1-MJMATHI-3B2\" x=\"389\" y=\"0\"></use><use xlink:href=\"#E1-MJMAIN-29\" x=\"963\" y=\"0\"></use></g></g></svg>";
}
